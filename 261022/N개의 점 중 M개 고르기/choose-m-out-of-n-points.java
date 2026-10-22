
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long ans = Long.MAX_VALUE;
    static Point[] arr;
    static int[] selected;
    static long[][] dist;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        long calc_dist(Point p2) {
            long dx = (long) p2.x - this.x;
            long dy = (long) p2.y - this.y;
            return dx * dx + dy * dy;
        }
    }

    static void dfs(int depth, int start, long mx) {
        if (mx >= ans) return;

        if (depth == m) {
            ans = Math.min(ans, mx);
            return;
        }

        for (int i = start; i < n; i++) {
            long next = mx;

            for (int j = 0; j < depth; j++) {
                next = Math.max(next, dist[i][selected[j]]);
            }

            if (next >= ans) continue;

            selected[depth] = i;
            dfs(depth + 1, i + 1, next);
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Point[n];
        selected = new int[m];
        dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = arr[i].calc_dist(arr[j]);
                dist[j][i] = dist[i][j];
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
    }
}
