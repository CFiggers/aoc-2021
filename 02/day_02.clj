(ns day-02
  (:require [clojure.string :as s]))

(def input 
  (map #(s/split % #" ") 
       (s/split-lines (slurp "./02/input.txt"))))

(defn run1 [[h-pos v-pos] [command value]]
  (let [n (Integer. value)]
    (case command
      "forward" [(+ h-pos n) v-pos]
      "up" [h-pos (- v-pos n)]
      "down" [h-pos (+ v-pos n)])))

(defn part1 [in] 
  (->> in
       (reduce run1 [0 0])
       (reduce *)))

(defn run2 [[h-pos v-pos aim] [command value]]
  (let [n (Integer. value)]
    (case command
      "forward" [(+ h-pos n) (+ v-pos (* n aim)) aim]
      "up" [h-pos v-pos (- aim n)]
      "down" [h-pos v-pos (+ aim n)])))

(defn part2 [in]
  (let [result (reduce run2 [0 0 0] in)]
    (* (first result) (second result))))

(defn print1 [] (println (str " - Part 1 Answer: " (part1 input))))
(defn print2 [] (println (str " - Part 2 Answer: " (part2 input))))