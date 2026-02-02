import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] grid = new int[n][n];
			for (int x = 0; x < n; x++) {
				st = new StringTokenizer(input.readLine());
				for (int y = 0; y < n; y++) {
					grid[x][y] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] prefixSum = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				prefixSum[i][0] = prefixSum[i - 1][0] + grid[i - 1][0];
				prefixSum[0][i] = prefixSum[0][i - 1] + grid[0][i - 1];
			}

			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					prefixSum[x][y] = prefixSum[x - 1][y] + prefixSum[x][y - 1] - prefixSum[x - 1][y - 1]
							+ grid[x - 1][y - 1];
				}
			}

			int ans = Integer.MIN_VALUE;
			for (int x = 0; x <= n - m; x++) {
				for (int y = 0; y <= n - m; y++) {
					int res = prefixSum[x+m][y+m] - prefixSum[x][y+m] - prefixSum[x+m][y] + prefixSum[x][y];
					ans = Math.max(ans, res);
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());

	}
}