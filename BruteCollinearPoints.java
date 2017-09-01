import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private int num;
    private Point[] copy;
    private LineSegment[] set;
	
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new NullPointerException();
            }
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].slopeTo(points[j]) == Double.NEGATIVE_INFINITY) {
                    throw new IllegalArgumentException();
                }
            }
        }
        copy = points.clone();
        set = new LineSegment[1];
        num = 0;
        Arrays.sort(copy);
        for (int i = 0; i < copy.length - 3; i++) {
            for (int j = i + 1; j < copy.length - 2; j++) {
                for (int k = j + 1; k < copy.length - 1; k++) {
                    for (int m = k + 1; m < copy.length; m++) {
                        if ((copy[i].slopeTo(copy[j]) == copy[j].slopeTo(copy[k])) && (copy[j].slopeTo(copy[k]) == copy[k].slopeTo(copy[m]))) {
                            LineSegment seg = new LineSegment(copy[i], copy[m]);
                            if (num >= set.length) {
                                LineSegment[] oldSet = new LineSegment[set.length * 2];
                                for (int n = 0; n < set.length; n++) {
                                    oldSet[n] = set[n];
                                }
                                set = oldSet;
                            }
                            set[num++] = seg;
                        }
                    }
                }
            }
        }
        if (num == 0) {
            set = new LineSegment[0];
        }
        if (num < set.length) {
            LineSegment[] oldSet = new LineSegment[num];
            for (int n = 0; n < num; n++) {
                oldSet[n] = set[n];
            }
            set = oldSet;
        }
        // finds all line segments containing 4 points
    }
	
    public int numberOfSegments() {
        return num;
        // the number of line segments
    }
	
    public LineSegment[] segments() {
        return set.clone();
        // the line segments
    }
	
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In("D:/Study/Graduate/coursera/Algorithms, Part I Princeton University/Pattern Recognition/collinear/input80.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
