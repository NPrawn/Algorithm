package D.가장_가까운_점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long dist() {
            return x + y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist() != b.dist()) {
                return Long.compare(a.dist(), b.dist());
            }
            if (a.x != b.x) {
                return Long.compare(a.x, b.x);
            }
            return Long.compare(a.y, b.y);
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        while (m-- > 0) {
            Point p = pq.poll();
            p.x += 2;
            p.y += 2;
            pq.offer(p);
        }

        Point ans = pq.poll();
        sb.append(ans.x).append(' ').append(ans.y);
        System.out.println(sb.toString());
    }
}
