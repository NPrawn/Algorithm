import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] p;

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n + 1];
			for (int i = 0; i <= n; i++)
				p[i] = i;

			PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(input.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				q.add(new int[] { c, a, b });
			}

			int ct = 0;
			long ans = 0;
			while (true) {
				if (ct == n - 1)
					break;
				int[] now = q.poll();
				int a = find(now[1]);
				int b = find(now[2]);
				if (a == b)
					continue;
				union(a, b);
				ans += now[0];
				ct += 1;
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
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

		if (a > b) {
			p[a] = b;
		} else {
			p[b] = a;
		}
	}
}