import java.io.*;
import java.util.*;

public class Main {
    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[100001];
        que.add(n);
        int[] dx = new int[]{1, -1};
        Arrays.fill(dist, -1);
        dist[n] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == k) {
                bw.write(Integer.toString(dist[cur]));
                bw.flush();
                System.exit(0);
            }
            for (int dir = 0; dir < 3; dir++) {
                int nx;

                if (dir == 2) {
                    nx = cur * 2;
                } else {
                    nx = cur + dx[dir];
                }
                if (nx > 100000 || nx < 0 || dist[nx] >= 0) {
                    continue;
                }
                dist[nx] = dist[cur] + 1;
                que.add(nx);
            }
        }

        br.close();
        bw.close();
    }
}