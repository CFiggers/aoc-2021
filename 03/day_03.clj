(ns day-03
  (:require [clojure.string :as str]
            [clojure.walk :as w]))

(defn transpose [m]
  (apply mapv vector m))

(transpose [[\a \b \c] [1 2 3]])

(defn most-frequent [vec & [default]]
  (loop [ones 0
         zeros 0
         vect vec]
    (if (= 0 (count vect))
      (if (= ones zeros) default (if (> ones zeros) 1 0))
      (if (= \0 (first vect))
        (recur ones (inc zeros) (rest vect))
        (recur (inc ones) zeros (rest vect))))))

(defn calc-gamma [filename]
  (Long/parseLong
   (->> (slurp filename)
        str/split-lines
        transpose
        (map most-frequent)
        (apply str)) 2))

(defn calc-epsilon [filename]
  (Long/parseLong
   (->> (slurp filename)
        str/split-lines
        transpose
        (map most-frequent)
        (map #(if (= 1 %) 0 1))
        (apply str)) 2))

(def input
  (str/split-lines (slurp "./03/input.txt")))

(defn get-filter-by [input index default]
  (as-> input x
    (transpose x)
    (most-frequent (nth x index) default)))

(defn filter-by [list val n]
  (filter #(= (Integer. (str (nth % n))) val) list))

(defn get-ox-gen-rating [in]
  (loop [output (filter-by in (get-filter-by in 0 1) 0)
         index 1]
    (if (> (count output) 1)
      (recur
       (filter-by output (get-filter-by output index 1) index)
       (inc index))
      output)))

(defn get-co2-rating [in]
  (loop [output (filter-by in (#(if (= 1 %) 0 1) (get-filter-by in 0 1)) 0)
         index 1]
    (if (> (count output) 1)
      (recur
       (filter-by output (#(if (= 1 %) 0 1) (get-filter-by output index 1)) index)
       (inc index))
      output)))

(defn print1 [] (println (str "- Part 1 Answer: " (let [file "./03/input.txt"]
                                                (* (calc-gamma file)
                                                   (calc-epsilon file))))))

(defn print2 [] (println (str "- Part 2 Answer: " (*
                                               (Long/parseLong (first (get-ox-gen-rating input)) 2)
                                               (Long/parseLong (first (get-co2-rating input)) 2)))))
