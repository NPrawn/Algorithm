import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] grid = new int[n][m];
			ArrayDeque<int[]> D = new ArrayDeque<>();
			ArrayDeque<int[]> S = new ArrayDeque<>();
			int[][] dist = new int[n][m];
			int[] ans = new int[2];
			
			for (int x = 0; x < n; x++) {
				String s = input.readLine();
				for (int y = 0; y < m; y++) {
					char c = s.charAt(y);
					if (c == 'S') {
						S.add(new int[] { x, y });
						dist[x][y] = 1;
					}
					else if (c == '*') {
						D.add(new int[] { x, y });
						grid[x][y] = 1;
					}
					else if (c == 'D') {
						grid[x][y] = -1;
						ans[0] = x;
						ans[1] = y;
					}
					else if (c == 'X') {
						grid[x][y] = -2;
					}
				}
			}
			
			while (!D.isEmpty()) {
				int[] now = D.pollFirst();
				int x =now[0];
				int y = now[1];
				for (int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0||ny<0||nx>=n||ny>=m) continue;
					if (grid[nx][ny] != 0) continue;
					grid[nx][ny] = grid[x][y] + 1;
					D.add(new int[] {nx,ny});
				}
			}
			
			while (!S.isEmpty()) {
				int[] now = S.pollFirst();
				int x = now[0];
				int y = now[1];
				for (int d=0;d<4;d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if (nx<0||ny<0||nx>=n||ny>=m) continue;
					if (grid[nx][ny] == -2) continue;
					if (dist[nx][ny] != 0) continue;
					if (grid[nx][ny] > 0 && grid[nx][ny] <= dist[x][y] + 1) continue;
					dist[nx][ny] = dist[x][y] + 1;
					S.add(new int[] {nx, ny});
				}
			}
			sb.append("#").append(tc).append(" ").append(dist[ans[0]][ans[1]] == 0 ? "GAME OVER" : dist[ans[0]][ans[1]]-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
