import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // + 모양 (상하좌우)
    static final int[] DX_PLUS = {1, 0, -1, 0};
    static final int[] DY_PLUS = {0, 1, 0, -1};

    // X 모양 (대각선)
    static final int[] DX_X = {1, 1, -1, -1};
    static final int[] DY_X = {1, -1, 1, -1};

    static int n, m;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, calc(i, j, DX_PLUS, DY_PLUS));
                    ans = Math.max(ans, calc(i, j, DX_X, DY_X));
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append('\n');
        }

        System.out.print(sb);
    }

    // (x, y)에서 방향 배열 기준으로 폭발 범위 합 계산
    static int calc(int x, int y, int[] dx, int[] dy) {
        int sum = grid[x][y];

        for (int d = 0; d < dx.length; d++) {
            for (int dist = 1; dist < m; dist++) {
                int nx = x + dx[d] * dist;
                int ny = y + dy[d] * dist;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                sum += grid[nx][ny];
            }
        }
        return sum;
    }
}
