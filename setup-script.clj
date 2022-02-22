#!/usr/bin/env bb

;; Run this function either using Babashka or an integrated
;; REPL such as Calva in VS Code
(do (require '[clojure.java.io :as io])
    (for [n (range 1 26)]
      (let [thisnum (format "%02d" n)
            thissample (str "./" thisnum "/sample.txt")
            thisinput (str "./" thisnum "/input.txt")
            thisfile (str "./" thisnum "/day-" thisnum ".clj")]
        (io/make-parents thissample)
        (spit thissample "" :append true)
        (spit thisinput "" :append true)
        (spit thisfile "" :append true)
        (when (empty? (slurp thisfile))
          (spit thisfile
                (str "(ns aoc-2021.day-" thisnum "\n"
                     "  (:require [clojure.string :as s]))"))))))