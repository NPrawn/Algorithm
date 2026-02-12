import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc<=T; tc++) {
			int n = Integer.parseInt(input.readLine());		
	
			int[][] s = new int[n][n];
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(input.readLine());
				for (int j=0;j<n;j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = Integer.MAX_VALUE;
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = i;
			}
			int full = (1 << n) - 1;
			for (int mask = 0; mask <= full; mask++) {
				if (Integer.bitCount(mask) != n/2) continue;
				ArrayList<Integer> A = new ArrayList<>();
				ArrayList<Integer> B = new ArrayList<>();
				
				for (int i=0;i<n;i++) {
					if ((mask & (1 << i)) != 0) A.add(arr[i]);
					else B.add(arr[i]);
				}
				
				int a = 0;
				int b = 0;
				
				for (int e1 : A) {
					for (int e2 : A) {
						a += s[e1][e2];
					}
				}
				for (int e1 : B) {
					for (int e2 : B) {
						b += s[e1][e2];
					}
				}
				
				ans = Math.min(ans, Math.abs(a-b));
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
