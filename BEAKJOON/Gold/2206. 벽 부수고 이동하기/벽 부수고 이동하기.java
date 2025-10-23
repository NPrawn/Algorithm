import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        public int x;
        public int y;
        public int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int[][][] board = new int[2][n][m];
        int[][][] dist = new int[2][n][m];
        Queue<Point> que = new LinkedList<>();



        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[0][i][j] = s.charAt(j) - '0';
                board[1][i][j] = s.charAt(j) - '0';
            }
        }

        que.add(new Point(0, 0, 0));
        dist[0][0][0] = 1;

        while (!que.isEmpty()) {
            Point cur = que.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                if (dist[0][cur.x][cur.y] == 0) {
                    result = dist[1][cur.x][cur.y];
                } else if (dist[1][cur.x][cur.y] == 0) {
                    result = dist[0][cur.x][cur.y];
                } else {
                    result = Math.min(dist[0][cur.x][cur.y], dist[1][cur.x][cur.y]);
                }
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z;
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (dist[nz][nx][ny] > 0) {
                    continue;
                }
                if (cur.z == 1 && board[nz][nx][ny] == 1) {
                    continue;
                }
                if (board[nz][nx][ny] == 1) {
                    dist[1][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                    que.add(new Point(nx, ny, 1));
                } else {
                    dist[nz][nx][ny] = dist[nz][cur.x][cur.y] + 1;
                    /*dist[1][cur.x][cur.y] = dist[0][cur.x][cur.y];*/
                    que.add(new Point(nx, ny, cur.z));
                }
            }
        }


        bw.write(Integer.toString(result) + "\n");

        br.close();
        bw.close();

    }
}