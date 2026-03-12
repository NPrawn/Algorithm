import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static HashSet<String> set;
	static char[][] grid;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			set = new HashSet<>();
			int ans = 0;
			grid = new char[4][4];
			for (int x = 0; x < 4; x++) {
				st = new StringTokenizer(input.readLine());
				for (int y = 0; y < 4; y++) {
					grid[x][y] = st.nextToken().charAt(0);
				}
			}

			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					dfs(x, y, 0, "");
				}
			}

			ans = set.size();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void dfs(int x, int y, int depth, String s) {
		if (depth == 7) {
			set.add(s);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
				continue;
			dfs(nx, ny, depth + 1, s + grid[nx][ny]);
		}
	}
}