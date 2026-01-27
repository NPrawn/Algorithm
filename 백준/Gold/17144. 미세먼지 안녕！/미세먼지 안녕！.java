import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, t;
    static int[][] grid;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x =x;
            this.y =y;
        }
    }

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        Point up = null;
        Point down = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == -1) {
                    if (up == null) {
                        up = new Point(i, j);
                    } else {
                        down = new Point(i, j);
                    }
                }
            }
        }

        while (t-- > 0) {
            expand();
            grid[up.x][up.y] = -1;
            grid[down.x][down.y] = -1;
            int x = up.x - 1;
            int y = up.y;
            int d = 2;
            while (!(x == up.x && y == up.y)) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || nx > up.x) {
                    d -= 1;
                    if (d==-1) d = 3;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                grid[x][y] = grid[nx][ny];
                x = nx;
                y = ny;
            }
            grid[up.x][up.y+1] = 0;

            x = down.x + 1;
            y = down.y;
            d = 0;
            while (!(x == down.x && y == down.y)) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || nx < down.x) {
                    d += 1;
                    if (d==4) d=0;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                grid[x][y] = grid[nx][ny];
                x = nx;
                y = ny;
            }
            grid[down.x][down.y+1] = 0;
        }

        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += grid[i][j];
            }
        }
        System.out.println(ans);
    }

    public static void expand() {
        int[][] newgrid = new int[n][m];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (grid[x][y] <= 0) continue;
                int k = grid[x][y] / 5;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (grid[nx][ny] == -1) continue;
                    newgrid[nx][ny] += k;
                    grid[x][y] -= k;
                }
                newgrid[x][y] += grid[x][y];
            }
        }
        grid = newgrid;
    }

}