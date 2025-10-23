import java.awt.desktop.AboutEvent;
import java.io.*;
import java.util.*;

public class Main {
    public static class Pair {
        public int x;
        public int y;
        public int z;

        public Pair(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] board = new int[h][n][m];
        int[][][] dist = new int[h][n][m];
        Queue<Pair> que = new LinkedList<>();
        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    board[z][i][j] = Integer.parseInt(st.nextToken());
                    if (board[z][i][j] == 1) {
                        que.add(new Pair(z, i, j));
                    }
                }
            }
        }
        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int max = 0;

        while (!que.isEmpty()) {
            Pair cur = que.poll();
                for (int dir = 0; dir < 6; dir++) {
                    int nz = cur.z + dz[dir];
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || nz < 0 || nz >= h) continue;
                    if (dist[nz][nx][ny] > 0 || board[nz][nx][ny] != 0) continue;
                    que.add(new Pair(nz, nx, ny));
                    dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                    max = Math.max(max, dist[nz][nx][ny]);
            }
        }

        for (int z = 0; z < h; z++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[z][i][j] == 0 && dist[z][i][j] == 0) {
                        bw.write("-1");
                        bw.flush();
                        System.exit(0);
                    }
                }
            }
        }
        bw.write(Integer.toString(max));

        br.close();
        bw.close();
    }
}