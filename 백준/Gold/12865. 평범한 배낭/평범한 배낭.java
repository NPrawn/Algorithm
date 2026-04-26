import java.io.*;

import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(input.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= k; j++) {
                if (j-w < 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
            }
        }

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(dp[n][i], ans);
        }
        System.out.println(ans);
    }
}
