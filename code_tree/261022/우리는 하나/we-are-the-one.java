
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k, u, d;
    static int[][] grid;
    static int[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int sx, int sy) {
        int res = 1;
        Deque<int[]> dq = new ArrayDeque<>();

        dq.addLast(new int[]{sx, sy});
        visited[sx][sy] = 1;

        while (!dq.isEmpty()) {
            int[] now = dq.removeFirst();
            int x = now[0];
            int y = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] == 1) continue;

                int diff = Math.abs(grid[nx][ny] - grid[x][y]);

                if (diff < u || diff > d) continue;

                visited[nx][ny] = 1;
                dq.addLast(new int[]{nx, ny});
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1) continue;

                sizes.add(bfs(i, j));
            }
        }

        sizes.sort(Collections.reverseOrder());

        int ans = 0;

        for (int i = 0; i < Math.min(k, sizes.size()); i++) {
            ans += sizes.get(i);
        }

        System.out.println(ans);
    }
}
