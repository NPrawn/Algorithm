import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 1, 0, -1, -1, 1, -1, 1 };
	static char[][] grid;
	static int n;

	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(input.readLine());
			grid = new char[n][n];
			int ans = 0;
			for (int x=0; x<n; x++) {
				String s = input.readLine();
				for (int y=0;y<n;y++) {
					grid[x][y] = s.charAt(y);
					if (grid[x][y] == '.') ans+=1;
				}
			}
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			boolean[][] vis = new boolean[n][n];
			for (int x=0;x<n;x++) {
				for (int y=0;y<n;y++) {
					if (grid[x][y] != '.') continue;
					if (check(x,y) != 0) continue;
					q.add(new int[] {x,y});
					vis[x][y] = true;
					while(!q.isEmpty()) {
						int[] now = q.pollFirst();
						for (int d=0; d<8; d++) {
							int nx = now[0] + dx[d];
							int ny = now[1] + dy[d];
							if (nx<0 || ny<0 || nx>=n || ny>= n) continue;
							if (vis[nx][ny]) continue;
							vis[nx][ny] = true;
							ans -= 1;
							if (check(nx,ny) != 0) continue;
							q.add(new int[] {nx,ny});
						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append('\n');

		}

		System.out.println(sb.toString());
	}
	
	static int check(int x, int y) {
		int ct = 0;
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;
			if (grid[nx][ny] != '.') {
				ct += 1;
			}
		}
		return ct;
	}
}