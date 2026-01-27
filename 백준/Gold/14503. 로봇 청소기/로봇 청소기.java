import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m;
    static int[][] grid;
    static int x, y, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            if (grid[x][y] == 0) {
                grid[x][y] = 2;
                ans += 1;
            }

            if (check()) {
                while (true) {
                    d -= 1;
                    if (d == -1) d = 3;
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if (grid[nx][ny] != 0) continue;
                    x = nx;
                    y = ny;
                    break;
                }

            } else {
                int nx = x + dx[(d + 2) % 4];
                int ny = y + dy[(d + 2) % 4];
                if (nx<0 || ny<0 || nx>=n || ny>=m) break;
                if (grid[nx][ny] == 1) break;
                x = nx;
                y = ny;
            }

        }

        System.out.println(ans);

    }
    public static boolean check() {
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if (grid[nx][ny] == 0) return true;
        }
        return false;
    }

}