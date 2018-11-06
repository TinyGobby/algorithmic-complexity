# Algorithmic Complexity

A simple benchmarking suite built using JMH for Makers Apprenticeships week 10, designed to be easy to use.

Code to be benchmarked should be put between lines 83-89, sample ArrayList methods already in place and commented for easy use.

Initially set up to run benchmarking tests on Java ArrayList methods with random numbers between 0-999 added to array sizes of:
- 1000, 2000, 3000, ..., 10,000 (linear increases)
- 1, 10, 100, ..., 1,000,000 (logarithmic increases)

Each test is set up to run 20 times as a warmup (results discarded) with 100 measured iterations averaged out. There is a 5 millisecond delay between iterations.

Output times can be returned in nanoseconds, microseconds, milliseconds or any standard units up to days.

Results can be printed in a .csv file for easy graphing

## To Build/Compile
```
mvn clean install
```

## To Run
```
java -jar target/benchmarks.jar -rf csv
```

Output will be in `test/jmh-result.csv`

## Sample Terminal Output
![In Terminal](https://i.imgur.com/j6Z416f.png)

## Sample CSV Output
![In Excel](https://i.imgur.com/Pa3G0ln.png)
