(defproject aoc-2021 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot aoc-2021.core
  :target-path "target/%s"
  :source-paths ["src"
                 "01" "02" "03" "04" "05"
                 "06" "07" "08" "09" "10"
                 "11" "12" "13" "14" "15"
                 "16" "17" "18" "19" "20"
                 "21" "22" "23" "24" "25"]
  :profiles {:uberjar {:aot :all}})
