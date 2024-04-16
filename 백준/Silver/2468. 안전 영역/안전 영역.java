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

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int p = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                p = Math.max(p, board[i][j]);
            }
        }
        int max = 0;
        Queue<Pair> que = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (p-- > 0) {
            boolean[][] vis = new boolean[n][n];
            int ct = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] <= p || vis[i][j]) continue;
                    que.add(new Pair(i, j));
                    vis[i][j] = true;
                    ct++;
                    while (!que.isEmpty()) {
                        Pair cur = que.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (vis[nx][ny] || board[nx][ny] <= p) continue;
                            que.add(new Pair(nx, ny));
                            vis[nx][ny] = true;
                        }
                    }
                }
            }
            max = Math.max(ct, max);
        }

        bw.write(Integer.toString(max));

        br.close();
        bw.close();

    }
}