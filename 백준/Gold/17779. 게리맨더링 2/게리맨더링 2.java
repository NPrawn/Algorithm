import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int total;
    static int ans = Integer.MAX_VALUE;
    static int[][] map;

    static void solve(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[n][n];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        int tmp = total;

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int sum = 0;
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                sum += map[i][j];
            }
        }
        tmp -= sum;
        max = Math.max(max, sum);
        min = Math.min(min, sum);

        sum = 0;
        for (int i = 0; i <= x + d2; i++) {
            for (int j = n - 1; j > y; j--) {
                if (border[i][j]) break;
                sum += map[i][j];
            }
        }
        tmp -= sum;
        max = Math.max(max, sum);
        min = Math.min(min, sum);

        sum = 0;
        for (int i = x + d1; i < n; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                sum += map[i][j];
            }
        }
        tmp -= sum;
        max = Math.max(max, sum);
        min = Math.min(min, sum);

        sum = 0;
        for (int i = x + d2 + 1; i < n; i++) {
            for (int j = n - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                sum += map[i][j];
            }
        }
        tmp -= sum;
        max = Math.max(max, sum);
        min = Math.min(min, sum);

        max = Math.max(max, tmp);
        min = Math.min(min, tmp);

        int res = max - min;

        ans = Math.min(res, ans);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 1; d1 < n; d1++) {
                    for (int d2 = 1; d2 < n; d2++) {
                        if (x + d1 + d2 >= n) continue;
                        if (y - d1 < 0 || y + d2 >= n) continue;

                        solve(x, y, d1, d2);
                    }
                }
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}