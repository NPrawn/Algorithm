import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		st = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] grid = new int[n][m];

		for (int x = 0; x < n; x++) {
			String s = input.readLine();
			for (int y = 0; y < m; y++) {
				grid[x][y] = s.charAt(y) - '0';
			}
		}

		int[][][] dist = new int[n][m][2];
		dist[0][0][0] = 1;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dq.add(new int[] { 0, 0, 0 });

		while (!dq.isEmpty()) {
			int[] now = dq.pollFirst();
			int x = now[0];
			int y = now[1];
			int k = now[2];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (dist[nx][ny][k] != 0)
					continue;
				if (grid[nx][ny] == 1 && k == 0) {
					dist[nx][ny][1] = dist[x][y][k] + 1;
					dq.add(new int[] { nx, ny, 1 });
				}
				if (grid[nx][ny] == 1) continue;
				dist[nx][ny][k] = dist[x][y][k] + 1;
				dq.add(new int[] {nx,ny,k});
			}
		}
		
		int a = dist[n-1][m-1][0];
		int b = dist[n-1][m-1][1];
		int ans = Math.min(a == 0 ? Integer.MAX_VALUE : a, b==0 ? Integer.MAX_VALUE : b);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		

	}
}
