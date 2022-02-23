(ns day-01
  (:require [clojure.string :as s]))

(def input 
  (map #(Integer. %) 
       (s/split-lines (slurp "./01/input.txt"))))

(defn part1 [in]
  (->> in
    (partition 2 1)
    (map #(if (< (first %) (second %)) 1 0))
    (reduce +)))

(defn part2 [in]
  (->> in
    (partition 3 1)
    (map #(reduce + %))
    part1))


(defn ans1 [] (str (part1 input)))
(defn ans2 [] (str (part2 input))) 