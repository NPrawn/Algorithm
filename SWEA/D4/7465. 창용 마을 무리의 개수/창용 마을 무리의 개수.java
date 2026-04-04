import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] p;

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				p[i] = i;
			}
			sb.append("#").append(tc).append(" ");

			while (m-- > 0) {
				st = new StringTokenizer(input.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			for (int i = 0; i < n + 1; i++) {
				find(i);
			}
			
			HashSet<Integer> s = new HashSet<>();
			for (int i=1; i<n+1; i++) {
				s.add(p[i]);
			}
			sb.append(s.size());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		if (a > b) {
			p[a] = b;
		} else {
			p[b] = a;
		}
	}
}