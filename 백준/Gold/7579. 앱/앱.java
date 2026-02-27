import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int total = 0;
		int ans = 0;

		st = new StringTokenizer(input.readLine());
		int[] app = new int[n];
		for (int i = 0; i < n; i++) {
			app[i] = Integer.parseInt(st.nextToken());
			total += app[i];
		}

		st = new StringTokenizer(input.readLine());
		int[] cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			ans += cost[i];
		}

		int[][] dp = new int[n + 1][ans + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= ans; j++) {
				if (j - cost[i-1] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]] + app[i-1]);
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<=ans; i++) {
			if (dp[n][i] >= m)
				min = Math.min(min, i);
		}

		System.out.println(min);
	}
}