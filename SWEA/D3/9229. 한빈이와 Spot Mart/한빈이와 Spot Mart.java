import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			st = new StringTokenizer(input.readLine());
			for (int i=0; i<n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			int l = 0;
			int r = n-1;
			int ans = Integer.MIN_VALUE;
			while (l<r) {
				int res = arr[l] + arr[r];
				if (res <= m) {
					l+=1;
				} else {
					r-=1;
				}
				if (res <= m && res > ans) ans = res;
			}
			sb.append(ans != Integer.MIN_VALUE ? ans : "-1").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}