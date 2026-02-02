import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		int T = 10;
		while (T-- > 0) {
			int t = Integer.parseInt(input.readLine());
			int n = 16;
			int[][] grid = new int[n][n];
			int sx = 0, sy = 0, ex = 0, ey = 0;

			for (int x = 0; x < n; x++) {
				String s = input.readLine();
				for (int y = 0; y < n; y++) {
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

			Deque<Point> q = new ArrayDeque<>();
			boolean[][] vis = new boolean[n][n];
			q.add(new Point(sx, sy));
			vis[sx][sy] = true;

			while (!q.isEmpty()) {
				Point now = q.pollFirst();
				int x = now.x;
				int y = now.y;
				
				for (int d=0; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
					if (vis[nx][ny]) continue;
					if (grid[nx][ny] == 1) continue;
					vis[nx][ny] = true;
					q.add(new Point(nx,ny));
				}
			}
			
			sb.append("#").append(t).append(" ").append(vis[ex][ey] ? 1 : 0).append("\n");

		}
		
		System.out.println(sb.toString());

	}
}