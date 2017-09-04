# Pattern-Recognition
A program to recognize line patterns in a given set of points. Given a set of n distinct points in the plane, find every (maximal) line segment that connects a subset of 4 or more of the points.

## Usage
* Open the FastCollinearPoints.java with a text editor.
* Set parameters
INPUT_PATH:
* Run the program
```java
$ java FastCollinearPoints input400.txt
```

## Demo
We test the program by several sample input files in the following format: An integer n, followed by n pairs of integers (x, y), each between 0 and 32,767. Below are one example:
* input400.txt<br>
(18150, 7150) -> (11250, 20950)<br>
(16450, 10750) -> (23200, 10750)<br>
(27400, 24750) -> (21900, 25250)<br>
(26000, 8900) -> (15250, 28250)<br>
(16050, 950) -> (1050, 15950)<br>
(29100, 24300) -> (18900, 26000)<br>
(20950, 9500) -> (20950, 28700)<br>
![input400](https://user-images.githubusercontent.com/26019998/30012958-53fc0470-90f8-11e7-8b88-adcc1ce70d4a.png)


## Dependencies
[stdlib.jar](http://algs4.cs.princeton.edu/code/stdlib.jar)<br>
[algs4.jar](http://algs4.cs.princeton.edu/code/algs4.jar)
