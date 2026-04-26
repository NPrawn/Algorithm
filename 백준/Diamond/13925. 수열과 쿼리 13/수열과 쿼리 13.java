import java.util.*;
import java.io.*;

class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int MOD = 1000000000 + 7;
	static int[] seg;
	static long[] lazymul;
	static long[] lazyadd;
	static int n;
	static int[] arr;

	public static void main(String args[]) throws Exception {
		n = Integer.parseInt(input.readLine());
		seg = new int[4 * n];
		lazymul = new long[4 * n];
		lazyadd = new long[4 * n];
		Arrays.fill(lazymul, 1);
		arr = new int[n + 1];

		st = new StringTokenizer(input.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		build(1, 0, n);
		int m = Integer.parseInt(input.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(input.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int v = Integer.parseInt(st.nextToken());
				update1(1, 0, n, l, r, v);
			} else if (cmd == 2) {
				int v = Integer.parseInt(st.nextToken());
				update2(1, 0, n, l, r, v);
			} else if (cmd == 3) {
				int v = Integer.parseInt(st.nextToken());
				update3(1, 0, n, l, r, v);
			} else {
				System.out.println(query(1, 0, n, l, r));
			}

		}
	}

	static void build(int node, int s, int e) {
		if (s == e) {
			seg[node] = arr[s];
			return;
		}

		int mid = s + (e - s) / 2;
		build(node * 2, s, mid);
		build(node * 2 + 1, mid + 1, e);
		seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
	}

	// 1 x y v: Ai = (Ai + v) % MOD를 수행한다. (x ≤ i ≤ y)
	static void update1(int node, int s, int e, int l, int r, int v) {
		propagate(node, s, e);
		if (e < l || r < s) {
			return;
		}
		if (l <= s && e <= r) {

			apply(node, s, e, 1, v);

			return;
		}

		int mid = s + (e - s) / 2;
		update1(node * 2, s, mid, l, r, v);
		update1(node * 2 + 1, mid + 1, e, l, r, v);
		seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
	}

	// 2 x y v: Ai = (Ai × v) % MOD를 수행한다. (x ≤ i ≤ y)
	static void update2(int node, int s, int e, int l, int r, int v) {
		propagate(node, s, e);
		if (e < l || r < s) {
			return;
		}
		if (l <= s && e <= r) {
			apply(node, s, e, v, 0);

			return;
		}

		int mid = s + (e - s) / 2;
		update2(node * 2, s, mid, l, r, v);
		update2(node * 2 + 1, mid + 1, e, l, r, v);
		seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
	}

	// 3 x y v: Ai = v를 수행한다. (x ≤ i ≤ y)
	static void update3(int node, int s, int e, int l, int r, int v) {
		propagate(node, s, e);
		if (r < s || e < l)
			return;
		if (l <= s && e <= r) {
			apply(node, s, e, 0, v);
			return;
		}

		int mid = s + (e - s) / 2;
		update3(node * 2, s, mid, l, r, v);
		update3(node * 2 + 1, mid + 1, e, l, r, v);
		seg[node] = (seg[node * 2] + seg[node * 2 + 1]) % MOD;
	}

	// 4 x y: (ΣAi) % MOD를 출력한다. (x ≤ i ≤ y)
	static int query(int node, int s, int e, int l, int r) {
		propagate(node, s, e);
		if (e < l || r < s)
			return 0;
		if (l <= s && e <= r)
			return seg[node];

		int mid = s + (e - s) / 2;
		return (query(node * 2, s, mid, l, r) + query(node * 2 + 1, mid + 1, e, l, r)) % MOD;
	}

	static void propagate(int node, int s, int e) {
		if (lazymul[node] == 1 && lazyadd[node] == 0)
			return;

		if (s != e) {
			int mid = s + (e - s) / 2;
			apply(node * 2, s, mid, lazymul[node], lazyadd[node]);
			apply(node * 2 + 1, mid + 1, e, lazymul[node], lazyadd[node]);
		}

		lazymul[node] = 1;
		lazyadd[node] = 0;
	}

	static void apply(int node, int s, int e, long mul, long add) {
		long len = e - s + 1L;
		seg[node] = (int) ((seg[node] * mul + len * add) % MOD);

		lazymul[node] = (lazymul[node] * mul) % MOD;
		lazyadd[node] = (lazyadd[node] * mul + add) % MOD;
	}
}