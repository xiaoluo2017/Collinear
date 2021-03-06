import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point
	
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        // Initializes a new point
    }

    public void draw() {
        StdDraw.point(x, y);
        // Draws this point to standard draw
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
        // Draws the line segment between this point and the specified point to standard draw
    }
    
    
    public double slopeTo(Point that) {
        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return 0;
        } else {
    	      return ((double)(that.y - this.y))/(that.x - this.x);
        }
        /*
        Returns the slope between this point and the specified point.
        Formally, if the two points are (x0, y0) and (x1, y1), then the slope
        is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
        +0.0 if the line segment connecting the two points is horizontal;
        Double.POSITIVE_INFINITY if the line segment is vertical;
        and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
        */
    }

    
    public int compareTo(Point that) {
        if (this.y == that.y) {
            return this.x - that.x;
        }
        return this.y - that.y;
        /*
        Compares two points by y-coordinate, breaking ties by x-coordinate.
        Formally, the invoking point (x0, y0) is less than the argument point
        (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1
        */
    }

    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                if (p1.slopeTo(Point.this) == p2.slopeTo(Point.this)) {
                    return 0;
                } else if (p1.slopeTo(Point.this) < p2.slopeTo(Point.this)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        // Compares two points by the slope they make with this point; The slope is defined as in the slopeTo() method
    }
  
    public String toString() {
        return "(" + x + ", " + y + ")";
        // Returns a string representation of this point
    }
    
    public static void main(String[] args) {
        // Unit tests
    	
    }
}
