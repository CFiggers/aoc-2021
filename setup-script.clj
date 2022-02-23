#!/usr/bin/env bb

;; Run this function either using Babashka or an integrated
;; REPL such as Calva in VS Code
(do (require '[clojure.java.io :as io])
    (for [n (range 1 26)]
      (let [thisnum (format "%02d" n)
            thissample (str "./" thisnum "/sample.txt")
            thisinput (str "./" thisnum "/input.txt")
            thisfile (str "./" thisnum "/day_" thisnum ".clj")]
        (io/make-parents thissample)
        (spit thissample "" :append true)
        (spit thisinput "" :append true)
        (spit thisfile "" :append true)
        (when (empty? (slurp thisfile))
          (spit thisfile
                (str "(ns day-" thisnum "\n"
                     "  (:require [clojure.string :as s]))" "\n"
                     "" "\n"
                     "(s/split-lines (slurp \"./" thisnum "/sample.txt\"))" "\n"
                     "" "\n"
                     "(defn part1 [] \"Not implemented yet\")"
                     "" "\n"
                     "(defn part2 [] \"Not implemented yet\")" "\n"
                     "" "\n"
                     "(defn ans1 [] \"Not implemented yet\")" "\n"
                     "(defn ans2 [] \"Not implemented yet\")"))))))