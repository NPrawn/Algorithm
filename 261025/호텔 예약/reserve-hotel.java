import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static List<Point> arr;

    static class Point {
        int x;
        int val;

        Point (int x, int val) {
            this.x = x;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr.add(new Point(s, 1));
            arr.add(new Point(e, -1));
        }

        arr.sort((a, b) -> {
            if (a.x == b.x) {
                return Integer.compare(b.val, a.val);
            }
            return Integer.compare(a.x, b.x);
        });

        int ans = 0;
        int res = 0;

        for (int i=0; i<arr.size(); i++) {
            Point p = arr.get(i);
            res += p.val;
            ans = Math.max(ans, res);
        }

        System.out.println(ans);
    }
}