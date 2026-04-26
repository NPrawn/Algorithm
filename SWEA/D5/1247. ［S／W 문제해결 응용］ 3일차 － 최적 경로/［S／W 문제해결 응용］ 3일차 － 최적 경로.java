import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n;
	static int[] corp, home;
	static int[][] tar;
	static int ans = Integer.MAX_VALUE;
	static boolean[] used;

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc=1; tc<=T; tc++) {
			n = Integer.parseInt(input.readLine());
			st = new StringTokenizer(input.readLine());
			ans = Integer.MAX_VALUE;
			used = new boolean[n];
			corp = new int[2];
			corp[0] = Integer.parseInt(st.nextToken());
			corp[1] = Integer.parseInt(st.nextToken());
			home = new int[2];
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			tar = new int[n][2];
			for (int i=0;i<n;i++) {
				tar[i][0] = Integer.parseInt(st.nextToken());
				tar[i][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(home[0], home[1], 0, 0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y, int res, int depth) {
		if (depth == n) {
			ans = Math.min(ans, res + Math.abs(corp[0] - x) + Math.abs(corp[1] - y));
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (used[i]) continue;
			used[i] = true;
			dfs(tar[i][0], tar[i][1], res + Math.abs(tar[i][0] - x) + Math.abs(tar[i][1] - y), depth + 1);
			used[i] = false;
		}
	}
}