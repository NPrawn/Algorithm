import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int ans;

    static void solve(int x, int y, int d) {
        if (x == n && y == n) {
            ans++;
            return;
        }

        switch (d) {
            case 0:
                if (y + 1 <= n && map[x][y + 1] == 0) {
                    solve(x, y + 1, 0);
                }
                break;
            case 1:
                if (x + 1 <= n && map[x + 1][y] == 0) {
                    solve(x + 1, y, 1);
                }
                break;
            case 2: // 파이프가 대각선일 경우, 갈 수 있는 경우는 동쪽과 남쪽, 대각선임.
                if (y + 1 <= n && map[x][y + 1] == 0) { // 동쪽
                    solve(x, y + 1, 0);
                }

                if (x + 1 <= n && map[x + 1][y] == 0) { // 남쪽
                    solve(x + 1, y, 1);
                }
                break;
        }

        if (y + 1 <= n && x + 1 <= n && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            solve(x + 1, y + 1, 2);
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        solve(1, 2, 0);

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}