import java.util.Comparator;
public class Point implements Comparable<Point> {
    public static final Comparator<Point> SLOPE_ORDER = new BySlopeOrder();   
    private final int x;
    private final int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private static class BySlopeOrder implements Comparator<Point> {
         public int compare(Point a, Point b){
             double temp = a.slopeTo(a) - b.slopeTo(b);
             if (temp > 0) {
                return 1;
             }
            else if (temp < 0) {
                return -1;
            }
            else {
                return 0;
            }
         }
     }
   
    public void draw() {
        StdDraw.point(x, y);
    }
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }                      
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
         
     public int compareTo(Point that) {
         if ((this.x == that.x ) && (that.x == this.x))  return 0;
         else if ((this.y == that.y) && (this.x < that.y)) return -1;
         else if (this.y < that.y) return -1;
         else return 1;
     }               
     public double slopeTo(Point that) {
         if ((this.x == this.y) && (this.y == that.y)) return Double.NEGATIVE_INFINITY;
         else if (this.y == that.y) return 0.0;
         else if (this.x == that.x) return Double.POSITIVE_INFINITY;
         else if ((that.x - this.x) == 0) {
            if ((that.y - this.y) > 0) {
                return 0.0;
            }
            if ((that.y - this.y) == 0) {
                return 0.0;
            }
            else {
                return -0.0;
            }
        }
         else {
            return ((double)(that.y - this.y) / (double)(that.x - this.x));
        }
     }
     
}