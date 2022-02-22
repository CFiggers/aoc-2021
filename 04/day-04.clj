(ns aoc-2021.day-04
  (:require [clojure.string :as s]
            [clojure.pprint :as p]
            [clojure.walk   :as w]))

;; Part 1: Get input
(def input
  (filter #(not= '("") %)
          (partition-by
           #(= "" %)
           (s/split-lines (slurp "./04/sample.txt")))))

(def bingocalls
  (s/split (first (first input)) #","))

(def boards
  (let [bs (rest input)
        ix (count input)]
    (zipmap (range 1 (inc ix))
            (for [b bs]
              (zipmap [1 2 3 4 5]
                      (for [r b]
                        (zipmap [:a :b :c :d :e]
                                (for [n (s/split (s/trim r) #" +")]
                                 {n false}))))))))

;; Part 2: Mark bingo calls
(defn up-all [bs t]
  (w/postwalk 
   #(if (vector? %) (if (= (first %) t) [t true] %) %) bs))

;; Part 3: Check for winning boards
(def h-win-boards
  {1
   {1
    {:a {"22" false},
     :b {"13" false},
     :c {"17" false},
     :d {"11" false},
     :e {"0" false}},
    2
    {:a {"8" true},
     :b {"2" true},
     :c {"23" true},
     :d {"4" true},
     :e {"24" true}},
    3
    {:a {"21" false},
     :b {"9" false},
     :c {"14" false},
     :d {"16" false},
     :e {"7" false}},
    4
    {:a {"6" false},
     :b {"10" false},
     :c {"3" false},
     :d {"18" false},
     :e {"5" false}},
    5
    {:a {"1" false},
     :b {"12" false},
     :c {"20" false},
     :d {"15" false},
     :e {"19" false}}},
   2
   {1
    {:a {"3" false},
     :b {"15" false},
     :c {"0" false},
     :d {"2" false},
     :e {"22" false}},
    2
    {:a {"9" false},
     :b {"18" false},
     :c {"13" false},
     :d {"17" false},
     :e {"5" false}},
    3
    {:a {"19" false},
     :b {"8" false},
     :c {"7" false},
     :d {"25" false},
     :e {"23" false}},
    4
    {:a {"20" false},
     :b {"11" false},
     :c {"10" false},
     :d {"24" false},
     :e {"4" false}},
    5
    {:a {"14" false},
     :b {"21" false},
     :c {"16" false},
     :d {"12" false},
     :e
     {"6" false}}},
   3
   {1
    {:a {"14" false},
     :b {"21" false},
     :c {"17" false},
     :d {"24" false},
     :e {"4" false}},
    2
    {:a {"10" false},
     :b {"16" false},
     :c {"15" false},
     :d {"9" false},
     :e {"19" false}},
    3
    {:a {"18" false},
     :b {"8" false},
     :c {"23" false},
     :d {"26" false},
     :e {"20" false}},
    4
    {:a {"22" false},
     :b {"11" false},
     :c {"13" false},
     :d {"6" false},
     :e {"5" false}},
    5
    {:a {"2" false},
     :b {"0" false},
     :c {"12" false},
     :d {"3" false},
     :e {"7" false}}}})

(defn check-h [bs]
  ((into {}
         (for [board (keys bs)]
           {(some true?
                  (for [row [1 2 3 4 5]]
                    (every? #(= true %)
                            (map #(first (vals (second %)))
                                 (get-in bs [board row])))))
            board})) true))

(check-h h-win-boards)

(defn check-v [bs]
  )

(defn check-x [bs]
  )

(defn check-winner [bs]
  bs)


;; Part 4: Calculate winning score

(defn calc-score []
  )

(p/pprint (reduce up-all boards bingocalls))

(p/pprint (up-all "22" boards))
