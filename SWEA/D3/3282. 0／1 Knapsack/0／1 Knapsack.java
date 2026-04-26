import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][k + 1];
            int[][] items = new int[n+1][2];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(input.readLine());
                items[i][0] = Integer.parseInt(st.nextToken());
                items[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j - items[i][0] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[n][k]).append("\n");
        }

        System.out.println(sb.toString());
    }

}