import java.io.*;

import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        int[][] dp = new int[15][15];
        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        while (T-- > 0) {
            int n = Integer.parseInt(input.readLine());
            int k = Integer.parseInt(input.readLine());

            System.out.println(dp[n][k]);
        }
    }
}
