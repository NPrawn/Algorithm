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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (h == 0 && n == 0 && m == 0) {
                break;
            }

            char[][][] board = new char[h][n][m];
            int[][][] dist = new int[h][n][m];
            Queue<Pair> que = new LinkedList<>();

            for (int z = 0; z < h; z++) {
                for (int i = 0; i < n; i++) {
                    String s = br.readLine();
                    for (int j = 0; j < m; j++) {
                        board[z][i][j] = s.charAt(j);
                        dist[z][i][j] = -1;
                        if (board[z][i][j] == 'S') {
                            que.add(new Pair(z, i, j));
                            dist[z][i][j] = 0;
                        }
                    }
                }
                br.readLine();
            }
            int[] dz = {0, 0, 0, 0, 1, -1};
            int[] dx = {1, 0, -1, 0, 0, 0};
            int[] dy = {0, 1, 0, -1, 0, 0};
            boolean error = true;

            while (!que.isEmpty()) {
                Pair cur = que.poll();
                for (int dir = 0; dir < 6; dir++) {
                    int nz = cur.z + dz[dir];
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nz < 0 || nx < 0 || ny < 0 || nz >= h || nx >= n || ny >= m) continue;
                    if (dist[nz][nx][ny] >= 0 || board[nz][nx][ny] == '#') continue;
                    if (board[nz][nx][ny] == 'E') {
                        bw.write("Escaped in " + Integer.toString(dist[cur.z][cur.x][cur.y] + 1) + " minute(s).\n");
                        que.clear();
                        error=false;
                        break;
                    }
                    que.add(new Pair(nz, nx, ny));
                    dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                }
            }
            if (error) {
                bw.write("Trapped!\n");
            }
        }

        br.close();
        bw.close();

    }
}