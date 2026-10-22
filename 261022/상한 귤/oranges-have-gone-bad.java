import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[][] grid;
    static int[][] dist;
    static Deque<int[]> dq;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        dist = new int[n][n];
        dq = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (grid[i][j] == 2) {
                    dq.addLast(new int[] {i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] now = dq.removeFirst();
            int x = now[0];
            int y = now[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
                if (dist[nx][ny] != -1) continue;
                if (grid[nx][ny] != 1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                dq.addLast(new int[] {nx, ny});
            }
        }

        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1 && dist[i][j] == -1) {
                    sb.append("-2 ");
                }
                else {
                    sb.append(dist[i][j] + " ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}