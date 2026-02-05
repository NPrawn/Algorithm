import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
    	int T = Integer.parseInt(input.readLine());
    	for (int t = 1; t<=T; t++) {
    		st = new StringTokenizer(input.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		
    		int[][] dp = new int[n+1][k+5];
    		int ans = 0;
    		
    		for (int i=1; i<=n; i++) {
    			st = new StringTokenizer(input.readLine());
    			int v = Integer.parseInt(st.nextToken());
    			int w = Integer.parseInt(st.nextToken());
    			
    			for (int j=0; j<k; j++) {
    				if (j-w >= 0)
    					dp[i][j] = dp[i-1][j-w] + v;
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
    				ans = Math.max(dp[i][j], ans);
    			}
    		}
    		
    		sb.append("#").append(t).append(" ").append(ans).append("\n");
    	}
    	System.out.println(sb.toString());
    }
}
