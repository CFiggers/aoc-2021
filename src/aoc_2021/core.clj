(ns aoc-2021.core
  (:require [day-01 :as one]
            [day-02 :as two]
            [day-03 :as three]
            [day-04 :as four]
            [day-05 :as five]
            [day-06 :as six]
            [day-07 :as sev]
            [day-08 :as eight]
            [day-09 :as nine]
            [day-10 :as ten]
            [day-11 :as elev]
            [day-12 :as twel]
            [day-13 :as thirt]
            [day-14 :as fourt]
            [day-15 :as fift]
            [day-16 :as sist]
            [day-17 :as sevt]
            [day-18 :as eigt]
            [day-19 :as nint]
            [day-20 :as twent]
            [day-21 :as tone]
            [day-22 :as ttwo]
            [day-23 :as tthree]
            [day-24 :as tfour]
            [day-25 :as tfive]))

(defmacro aoc-day [n ns]
  `(do
     (println (str "Day " ~n ":"))
     (@(resolve (symbol ~ns "print1")))
     (@(resolve (symbol ~ns "print2")))))

(defn -main []
  (binding [*ns* (find-ns 'aoc-2021.core)]
    (aoc-day 1 "one")
    (aoc-day 2 "two")
    (aoc-day 3 "three")
    (aoc-day 4 "four")
    (aoc-day 5 "five")
    (aoc-day 6 "six")
    (aoc-day 7 "sev")
    (aoc-day 8 "eight")
    (aoc-day 9 "nine")
    (aoc-day 10 "ten")
    (aoc-day 11 "elev")
    (aoc-day 12 "twel")
    (aoc-day 13 "thirt")
    (aoc-day 14 "fourt")
    (aoc-day 15 "fift")
    (aoc-day 16 "sist")
    (aoc-day 17 "sevt")
    (aoc-day 18 "eigt")
    (aoc-day 19 "nint")
    (aoc-day 20 "twent")
    (aoc-day 21 "tone")
    (aoc-day 22 "ttwo")
    (aoc-day 23 "tthree")
    (aoc-day 24 "tfour")
    (aoc-day 25 "tfive")))