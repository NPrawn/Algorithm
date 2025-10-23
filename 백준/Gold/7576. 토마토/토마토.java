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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = 0;
                if (board[i][j] == 1) {
                    que.add(new Pair(i, j));
                }
                if (board[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] != 0 || dist[nx][ny] >= 0) {
                    continue;
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                que.add(new Pair(nx, ny));
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    bw.write("-1");
                    bw.flush();
                    System.exit(0);
                }
                ans = Math.max(dist[i][j], ans);
            }
        }
        bw.write(Integer.toString(ans));


        br.close();
        bw.close();
    }
}