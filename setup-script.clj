#!/usr/bin/env bb

(for [n (range 1 31)]
  (let [thisnum (format "%02d" n)
        thisfile (str "./" thisnum "/day-" thisnum ".clj")]
    (when (= "" (slurp thisfile)) 
      (spit thisfile 
            (str "(ns aoc-2021.day-" thisnum "\n"  
                 "  (:require [clojure.string :as s]))")))))