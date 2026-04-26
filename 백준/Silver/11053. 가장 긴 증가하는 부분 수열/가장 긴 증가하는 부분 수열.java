import java.io.*;

import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int mx = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    mx = Math.max(dp[j], mx);
                }
            }
            dp[i] = mx+1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
