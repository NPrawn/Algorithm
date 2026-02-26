import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
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
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int[][] dist = new int[n][m];
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		dist[0][0] = 1;
		dq.add(new int[] {0,0});
		
		while(!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int x = cur[0];
			int y = cur[1];
			
			for (int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || ny < 0 || nx>=n || ny>=m) continue;
				if (grid[nx][ny] == 0) continue;
				if (dist[nx][ny] != 0) continue;
				dq.add(new int[] {nx, ny});
				dist[nx][ny] = dist[x][y] + 1;
			}
		}
		System.out.println(dist[n-1][m-1]);
	}
}
