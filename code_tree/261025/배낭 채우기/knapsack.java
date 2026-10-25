import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];
        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            int w = weight[i-1];
            int v = value[i-1];

            for (int j=0; j<=m; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= w) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i-1][j-w] + v
                    );
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}