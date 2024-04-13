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
        int m = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        int ct = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                vis[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || vis[i][j]) {
                    continue;
                }
                ct++;
                Queue<Pair> que = new LinkedList<>();
                que.add(new Pair(i, j));
                vis[i][j] = true;
                int area = 0;
                while (!que.isEmpty()) {
                    area++;
                    Pair cur = que.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }
                        if (vis[nx][ny] || board[nx][ny] != 1) {
                            continue;
                        }
                        vis[nx][ny] = true;
                        que.add(new Pair(nx, ny));
                    }
                }
                max = Math.max(max, area);
            }
        }

        bw.write(Integer.toString(ct) + "\n" + Integer.toString(max));

        br.close();
        bw.close();
    }
}