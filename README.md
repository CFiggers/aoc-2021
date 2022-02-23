# Advent of Code 2021

Even though I'm way late for it this year and probably won't do them all, here's my attempts at Advent of Code 2021 in Clojure. Good luck, everybody.

## Setup-Script

To get started with the following folder structure, run the setup-script.clj function either in Babashka or by simply evaluating the main form in that file using an integrated REPL in an ide like CIDER or Calva.

```
├── 01
│   ├── day-01.clj
│   ├── input.txt
│   └── sample.txt
├── 02
│   ├── day-02.clj
│   ├── input.txt
│   └── sample.txt
|
[etc]
```

## -main function

Use `lein run` to see a readout of all days current status. E.g.: 

```
        Part 1                   Part 2
Day 1:  1502                     1538
Day 2:  2120749                  2138382217
Day 3:  3985686                  2555739
[etc]
```

To configure this ongoing, update the `ans1` and `ans2` functions at the bottom of each day's .clj file.