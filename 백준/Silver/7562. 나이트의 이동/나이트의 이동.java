import java.awt.desktop.AboutEvent;
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
            Queue<Pair> que = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[n][n];
            int[][] dist = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ansX = Integer.parseInt(st.nextToken());
            int ansY = Integer.parseInt(st.nextToken());
            board[ansX][ansY] = 2;
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            board[q][w] = 1;
            int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
            int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
            que.add(new Pair(q, w));
            while (!que.isEmpty()) {
                Pair cur = que.poll();
                if (cur.x == ansX && cur.y == ansY) {
                    bw.write(dist[cur.x][cur.y] + "\n");
                    break;
                }
                for (int dir = 0; dir < 8; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (dist[nx][ny] > 0) continue;
                    que.add(new Pair(nx, ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }

        br.close();
        bw.close();
    }
}