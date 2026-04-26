import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int ans = 0;

			HashMap<Integer, int[]> map = new HashMap<>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				int key = encode(x, y);
				map.put(key, new int[] { val, d });
				ans += val;
			}

			while (m-- > 0) {
				HashMap<Integer, int[]> newMap = new HashMap<>();
				for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
					int[] xy = decode(entry.getKey());
					int x = xy[0];
					int y = xy[1];
					int[] vald = entry.getValue();
					int val = vald[0];
					int d = vald[1];

					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) {
						ans -= val;
						val /= 2;
						ans += val;
						if (d == 1)
							d = 2;
						else if (d == 2)
							d = 1;
						else if (d == 3)
							d = 4;
						else if (d == 4)
							d = 3;
					}
					if (val == 0) continue;
					
					int key = encode(nx, ny);
					if (newMap.containsKey(key)) {
						int[] tmp = newMap.get(key);
						tmp[0] += val;
						
						if (val > tmp[2]) {
							tmp[2] = val;
							tmp[1] = d;
						}
					} else {
						newMap.put(key, new int[] {val, d, val});
					}
				}
				map.clear();
				for (Map.Entry<Integer, int[]> entry : newMap.entrySet()) {
					int key = entry.getKey();
					int[] v = entry.getValue();
					map.put(key, new int[] { v[0], v[1]});
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	static int encode(int a, int b) {
		return a * 1000 + b;
	}

	static int[] decode(int a) {
		return new int[] { a / 1000, a % 1000 };
	}
}