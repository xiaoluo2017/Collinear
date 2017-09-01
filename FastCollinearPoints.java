import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
    private Point[] copy;
    private LineSegment[] res;
    private int num;
	
    public FastCollinearPoints(Point[] points) {
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
        Arrays.sort(copy);
        res = new LineSegment[1];
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            Arrays.sort(copy, p.slopeOrder());
            int j = 1;
            while (j < points.length - 2) {
                int k = 1;
                while (j + k < points.length && p.slopeTo(copy[j]) == p.slopeTo(copy[j + k])) {
                    k++;
                }
                if (k > 2) {
                    Arrays.sort(copy, j, j + k);
                    if (p.compareTo(copy[j]) < 0) {
                        LineSegment se = new LineSegment(p, copy[j + k - 1]);
                        if (num >= res.length) {
                            LineSegment[] oldRes = new LineSegment[res.length * 2];
                            for (int n = 0; n < res.length; n++) {
                                oldRes[n] = res[n];
                            }
                            res = oldRes;
                        }
                        res[num++] = se;
                    }
                }
                j = j + k;
            }
        }
		
        if (num == 0) {
            res = new LineSegment[0];
        }
        if (num < res.length) {
            LineSegment[] oldRes = new LineSegment[num];
            for (int n = 0; n < num; n++) {
                oldRes[n] = res[n];
            }
            res = oldRes;
        }
        // finds all line segments containing 4 or more points
    }
	
    public int numberOfSegments() {
        return num;
        // the number of line segments
    }
	
    public LineSegment[] segments() {
        return res.clone();
        // the line segments
    }
	
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In("D:/Study/Graduate/coursera/Algorithms, Part I Princeton University/Pattern Recognition/collinear/input200.txt");
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
