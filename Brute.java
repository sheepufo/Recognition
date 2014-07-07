import java.util.Arrays;
public class Brute {
    public static void main(String[] args) {
        StdDraw.clear();
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show();
    
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] arr = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            arr[i] = p;
        }        
        Arrays.sort(arr);
        for (int a = 0; a < N; a++) {            
            for (int b = a + 1; b < N; b++) {
                for (int c = b + 1; c < N; c++) {
                    for (int d = c + 1; d < N; d++) {
                        // check whether the slopes between p and q, between 
                        // p and r, and between p and s are all equal.
                        double s1 = arr[a].slopeTo(arr[b]);
                        double s2 = arr[a].slopeTo(arr[c]);
                        double s3 = arr[a].slopeTo(arr[d]);
                        
                        if (s1 == s2 && s1 == s3 && s2 == s3) {
                            StdOut.println(arr[a] + " -> " + arr[b] + 
                                    " -> " + arr[c] + " -> " + arr[d]);
                            
                            arr[a].drawTo(arr[d]);
                        }
                    }
                }
            }
        }//end for
    }
}