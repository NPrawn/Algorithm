import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(input.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int ans = Integer.MAX_VALUE;
			int size = 1 << n;
			for (int mask = 0; mask < size; mask++) {
				int s = 0;
				for (int i = 0; i < n; i++) {
					if ((mask & (1 << i)) != 0)
						s += arr[i];
				}

				if (b <= s)
					ans = Math.min(ans, s);
			}

			sb.append("#").append(tc).append(" ").append(ans-b).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}