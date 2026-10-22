import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid;
    static int[][] visited;
    static int n;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new int[n][n];
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int ans = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 1) continue;
                dq.addLast(new int[] {i,j});
                visited[i][j] = 1;
                int num = grid[i][j];
                int area = 1;
                while (!dq.isEmpty()) {
                    int[] now = dq.removeFirst();
                    int x = now[0];
                    int y = now[1];

                    for (int d=0; d<4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (visited[nx][ny] == 1) continue;
                        if (grid[nx][ny] != num) continue;
                        dq.addLast(new int[] {nx, ny});
                        visited[nx][ny] = 1;
                        area += 1;
                    }
                }

                if (area >= 4) {
                    count += 1;
                }
                ans = Math.max(ans, area);
            }
        }

        System.out.println(count + " " + ans);
    }
}