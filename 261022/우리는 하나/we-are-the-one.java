import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k, u, d;
    static int[][] grid;
    static int ans = Integer.MIN_VALUE;
    static int[] arr;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void dfs(int depth, int start) {
        if (depth == k) {
            int res = 0;
            Deque<int[]> dq = new ArrayDeque<>();
            int[][] visited = new int[n][n];
            for (int i=0; i<k; i++) {
                int x = arr[i] / n;
                int y = arr[i] % n;
                dq.addLast(new int[] {x, y});
                visited[x][y] = 1;
                res += 1;
            }

            while (!dq.isEmpty()) {
                int[] now = dq.removeFirst();
                int x = now[0];
                int y = now[1];

                for (int dir=0; dir<4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visited[nx][ny] == 1) continue;
                    if (Math.abs(grid[nx][ny] - grid[x][y]) < u) continue;
                    if (Math.abs(grid[nx][ny] - grid[x][y]) > d) continue;
                    visited[nx][ny] = 1;
                    dq.addLast(new int[] {nx, ny});
                    res += 1;
                }
            }

            ans = Math.max(ans, res);
            return;
        }

        for (int i=start; i<n*n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        arr = new int[k];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }
}