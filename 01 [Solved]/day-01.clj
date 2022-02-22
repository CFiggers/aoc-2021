(ns aoc-2021.day-01
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

(print (str "Part 1 Answer: " (part1 input)))

(print (str "Part 2 Answer: " (part2 input)))