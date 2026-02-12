import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(input.readLine());
			st = new StringTokenizer(input.readLine());
			int[] arr = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			int max = arr[n-1];
			for (int i =0; i<n; i++) {
				arr[i] = max-arr[i];
			}
			
			int odd = 0;
			int even = 0;
			
			for (int a : arr) {
				even += a/2;
				odd += a%2;
			}
			
			int ans = 0;
			if (odd == even) ans = odd*2;
			else if (odd > even) {
				ans = odd*2-1;
			} else {
				while (odd + 1 < even) {
					even -= 1;
					odd += 2;
				}
				if (odd == even) ans = odd*2;
				else {
					ans = even*2;
					if (even+1 == odd) ans+=1;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
