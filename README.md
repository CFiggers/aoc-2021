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
Day 1:
 - Part 1 Answer: 1502
 - Part 2 Answer: 1538
Day 2:
 - Part 1 Answer: 2120749
 - Part 2 Answer: 2138382217
 Day 3:
 [etc]
```

To configure this ongoing, update the `print1` and `print2` functions at the bottom of each day's .clj file.