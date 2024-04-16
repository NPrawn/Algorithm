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

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][m];
            boolean[][] vis = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], 0);
                Arrays.fill(vis[i], false);
            }
            Queue<Pair> que = new LinkedList<>();
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            int ct = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1 && !vis[i][j]) {
                        que.add(new Pair(i, j));
                        vis[i][j] = true;
                        ct++;
                        while (!que.isEmpty()) {
                            Pair cur = que.poll();
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = cur.x + dx[dir];
                                int ny = cur.y + dy[dir];
                                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                    continue;
                                }
                                if (vis[nx][ny] || board[nx][ny] == 0) {
                                    continue;
                                }
                                vis[nx][ny] = true;
                                que.add(new Pair(nx, ny));
                            }
                        }
                    }
                }
            }
            bw.write(Integer.toString(ct) + "\n");
        }

        br.close();
        bw.close();
    }
}