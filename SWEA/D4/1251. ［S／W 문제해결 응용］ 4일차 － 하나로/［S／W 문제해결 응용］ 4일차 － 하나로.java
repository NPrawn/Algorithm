import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[] p;

	static class node {
		double w;
		int a;
		int b;

		node(double w, int a, int b) {
			this.w = w;
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(input.readLine());
			long[][] items = new long[n][2];
			p = new int[n + 1];
			for (int i = 0; i <= n; i++)
				p[i] = i;

			StringTokenizer st1 = new StringTokenizer(input.readLine());
			StringTokenizer st2 = new StringTokenizer(input.readLine());
			for (int i = 0; i < n; i++) {
				items[i][0] = Long.parseLong(st1.nextToken());
				items[i][1] = Long.parseLong(st2.nextToken());
			}

			double E = Double.parseDouble(input.readLine());
			PriorityQueue<node> q = new PriorityQueue<>((a, b) -> Double.compare(a.w, b.w));
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					double L = Math.pow(items[i][0] - items[j][0], 2) + Math.pow(items[i][1] - items[j][1], 2);
					double w = E * L;
					q.add(new node(w, i, j));
				}
			}

			int ct = 0;
			double ans = 0;

			while (true) {
				if (ct == n - 1)
					break;
				node now = q.poll();
				if (union(now.a, now.b)) {

					ct += 1;
					ans += now.w;
				}
			}
			sb.append("#").append(tc).append(" ").append(Math.round(ans)).append("\n");
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

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;
		if (a > b) {
			p[a] = b;
		} else {
			p[b] = a;
		}
		return true;
	}
}