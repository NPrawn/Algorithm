import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int t = Integer.parseInt(input.readLine());
			int[][] grid = new int[100][100];
			int sx = 0, sy = 0;
			int ex = 0, ey = 0;
			for (int x = 0; x < 100; x++) {
				String s = input.readLine();
				for (int y = 0; y < 100; y++) {
					grid[x][y] = s.charAt(y) - '0';
					if (grid[x][y] == 2) {
						sx = x;
						sy = y;
					}
					if (grid[x][y] == 3) {
						ex = x;
						ey = y;
					}
				}
			}

			ArrayDeque<int[]> dq = new ArrayDeque<>();
			dq.add(new int[] { sx, sy });
			boolean[][] vis = new boolean[100][100];
			vis[sx][sy] = true;
			while (!dq.isEmpty()) {
				int[] cur = dq.pollFirst();
				int x = cur[0];
				int y = cur[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if (nx<0||nx>=100||ny<0|ny>=100) continue;
					if (vis[nx][ny]) continue;
					if (grid[nx][ny] == 1) continue;
					vis[nx][ny] = true;
					dq.add(new int[] {nx,ny});
				}
			}
			
			sb.append("#").append(tc).append(" ").append(vis[ex][ey] ? 1 : 0).append("\n");

		}
		System.out.println(sb.toString());
	}
}
