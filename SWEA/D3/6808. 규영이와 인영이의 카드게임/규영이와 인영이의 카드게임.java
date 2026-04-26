import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int win = 0;
	static int lose = 0;
	static int n = 9;
	static boolean[] used = new boolean[19];
	static int[] A = new int[n];
	static int[] B = new int[n];

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int t=1; t<=T; t++) {
			used = new boolean[19];
			win = lose = 0;
			used[0] = true;
			st = new StringTokenizer(input.readLine());
			for (int i =0;i<n;i++) {
				A[i] = Integer.parseInt(st.nextToken());
				used[A[i]] = true;
			}
			
			dfs(0);
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int depth) {
		if (depth == n) {
			int a = 0;
			int b = 0;
			for (int i=0; i<n;i++) {
				if (A[i] > B[i]) a += A[i]+B[i];
				else b+= A[i]+B[i];
			}
			if (a > b) win+=1;
			else lose+=1;
			return;
		}
		
		for(int k=1; k<19; k++) {
			if (used[k]) continue;
			B[depth] = k;
			used[k] = true;
			dfs(depth + 1);
			used[k] = false;
		}
	}
}