#!/usr/bin/env bb

;; Run this function either using Babashka or an integrated
;; REPL such as Calva in VS Code
(do (require '[clojure.java.io :as io])
    (for [n (range 1 31)]
      (do (io/make-parents (str "./" (format "%02d" n) "/sample.txt"))
          (spit (str "./" (format "%02d" n) "/sample.txt") "" :append true)
          (spit (str "./" (format "%02d" n) "/input.txt") "" :append true)
          (spit (str "./" (format "%02d" n) "/day-" (format "%02d" n) ".clj") "" :append true)
          (when (empty? (slurp (str "./" (format "%02d" n) "/day-" (format "%02d" n) ".clj")))
            (spit (str "./" (format "%02d" n) "/day-" (format "%02d" n) ".clj")
                  (str "(ns aoc-2021.day-" (format "%02d" n) "\n"
                       "  (:require [clojure.string :as s]))"))))))