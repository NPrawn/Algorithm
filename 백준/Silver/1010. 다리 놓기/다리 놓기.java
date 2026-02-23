import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        int[][] dp = new int[31][31];
        for (int i = 1; i < 31; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        while (T-- > 0) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(dp[m][n]);
        }
    }
}