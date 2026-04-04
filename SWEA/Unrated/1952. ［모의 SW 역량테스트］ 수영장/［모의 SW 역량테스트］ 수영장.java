import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc<=T; tc++) {
			st = new StringTokenizer(input.readLine());
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int month3 = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			int n = 12;
			int[] arr = new int[n+1];
			st = new StringTokenizer(input.readLine());
			for (int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[13];
			for(int i=1; i<13;i++) {
				int k = i - 3;
				if (k < 0) k = 0;
				dp[i] = Math.min(dp[i-1] + Math.min(day*arr[i], month), dp[k] + month3);
			}
			int ans = Math.min(year, dp[12]);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
