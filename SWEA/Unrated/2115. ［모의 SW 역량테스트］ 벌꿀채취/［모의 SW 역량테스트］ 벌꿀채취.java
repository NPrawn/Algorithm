import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int best;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[][] grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			for (int x1 = 0; x1 < n; x1++) {
				for (int y1 = 0; y1 <= n - m; y1++) {
					int[] seg = new int[m];
					best = 0;
					for (int i = 0; i < m; i++)
						seg[i] = grid[x1][y1 + i];
					dfs(seg, 0, 0, 0, c);
					int res1 = best;

					for (int x2 = x1; x2 < n; x2++) {
						int stY = (x2 == x1) ? (y1 + m) : 0;
						for (int y2 = stY; y2 <= n - m; y2++) {
							seg = new int[m];
							best = 0;
							for (int i = 0; i < m; i++)
								seg[i] = grid[x2][y2 + i];
							dfs(seg, 0, 0, 0, c);
							int res2 = best;

							ans = Math.max(ans, res1 + res2);
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void dfs(int[] seg, int idx, int sum, int val, int C) {
		if (sum > C)
			return;
		if (idx == seg.length) {
			best = Math.max(best, val);
			return;
		}
		dfs(seg, idx + 1, sum + seg[idx], val + seg[idx] * seg[idx], C);
		dfs(seg, idx + 1, sum, val, C);
	}

}
