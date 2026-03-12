import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, w, h;
	static int[][] grid;
	static boolean[] used;
	static int ans;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			used = new boolean[w];

			grid = new int[h][w];
			for (int x = 0; x < h; x++) {
				st = new StringTokenizer(input.readLine());
				for (int y = 0; y < w; y++) {
					grid[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			ans = Integer.MAX_VALUE;
			int[] arr = new int[n];
			dfs(0, arr);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int depth, int[] arr) {
		if (depth == n) {
			simul(arr);
			return;
		}

		for (int i = 0; i < w; i++) {
			if (used[i])
				continue;
			arr[depth] = i;
			dfs(depth + 1, arr);
		}
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;

	static void simul(int[] arr) {
		map = new int[h][w];
		for (int x = 0; x < h; x++)
			for (int y = 0; y < w; y++)
				map[x][y] = grid[x][y];

		for (int e : arr) {
			int x = 0;
			int y = e;

			while (x < h && map[x][y] == 0) {
				x += 1;
			}
			if (x == h) continue;

			int k = map[x][y];
			bomb(x, y, k);
			gravity(map);
		}

		int ct = 0;
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				if (map[x][y] != 0)
					ct += 1;
			}
		}
		ans = Math.min(ans, ct);
	}

	static void bomb(int x, int y, int k) {
		map[x][y] = 0;
		ArrayList<int[]> lst = new ArrayList<>();
		for (int d = 0; d < 4; d++) {
			for (int t = 1; t < k; t++) {
				int nx = x + dx[d] * t;
				int ny = y + dy[d] * t;
				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;
				if (map[nx][ny] != 0) {
					lst.add(new int[] { nx, ny, map[nx][ny] });
					map[nx][ny] = 0;
				}
			}
		}

		for (int[] e : lst) {
			bomb(e[0], e[1], e[2]);
		}
	}

	static void gravity(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		for (int y = 0; y < m; y++) {
			int write = n - 1;

			for (int x = n - 1; x >= 0; x--) {
				if (arr[x][y] != 0) {
					int temp = arr[x][y];
					arr[x][y] = 0;
					arr[write][y] = temp;
					write--;
				}
			}
		}
	}
}