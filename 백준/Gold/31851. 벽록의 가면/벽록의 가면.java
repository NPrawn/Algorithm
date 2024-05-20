import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = 0;
    static Point[] arr;
    static int[] com;
    static boolean[] isUsed;

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(Point p1, Point p2, Point p3, Point p4) {
        long res = ((p2.x - p1.x) * (p4.y - p1.y)) - ((p2.y - p1.y) * (p4.x - p1.x));
        if (res < 0) return false;
        res = ((p3.x - p2.x) * (p1.y - p2.y)) - ((p3.y - p2.y) * (p1.x - p2.x));
        if (res < 0) return false;
        res = ((p4.x - p3.x) * (p2.y - p3.y)) - ((p4.y - p3.y) * (p2.x - p3.x));
        if (res < 0) return false;
        res = ((p1.x - p4.x) * (p3.y - p4.y)) - ((p1.y - p4.y) * (p3.x - p4.x));
        if (res < 0) return false;

        return true;
    }

    static void permutation(int cur) {
        if (cur == 4) {
            if (check(arr[com[0]], arr[com[1]], arr[com[2]], arr[com[3]])) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            com[cur] = i;
            permutation(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Point[n];
        com = new int[4];
        isUsed = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }

        permutation(0);

        sb.append(ans / 4);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}