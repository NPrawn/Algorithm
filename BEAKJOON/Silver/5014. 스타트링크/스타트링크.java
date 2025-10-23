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
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        boolean error = true;

        int[] dist = new int[f + 1];
        Arrays.fill(dist, -1);
        int[] board = new int[f + 1];
        board[s] = 1;
        int[] dx = {u, -d};

        que.add(s);
        dist[s] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            if (cur == g) {
                bw.write(Integer.toString(dist[cur]));
                error = false;
            }
            for (int dir = 0; dir < 2; dir++) {
                int nx = cur + dx[dir];
                if (nx <= 0 || nx > f) continue;
                if(dist[nx] >= 0) continue;
                que.add(nx);
                dist[nx] = dist[cur] + 1;
            }
        }

        if (error) {
            bw.write("use the stairs");
        }

        br.close();
        bw.close();

    }
}