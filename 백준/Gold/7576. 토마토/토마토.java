import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		st = new StringTokenizer(input.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] grid = new int[n][m];
		int[][] dist = new int[n][m];
		int ans = 0;
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		for (int x=0;x<n;x++) {
			st = new StringTokenizer(input.readLine());
			for (int y=0;y<m;y++) {
				grid[x][y] = Integer.parseInt(st.nextToken());
				if (grid[x][y] == 1) {
					dq.add(new int[] {x,y});
					dist[x][y] = 1;
				}
			}
		}
		
		while (!dq.isEmpty()) {
			int[] now = dq.pollFirst();
			int x = now[0];
			int y = now[1];
			
			for (int d=0; d<4;d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if (nx<0||ny<0||nx>=n||ny>=m) continue;
				if (dist[nx][ny] != 0) continue;
				if (grid[nx][ny] == -1) continue;
				dist[nx][ny] = dist[x][y] + 1;
				dq.add(new int[] {nx,ny});
			}
		}
		
		for (int x=0; x<n; x++) {
			for (int y=0; y<m; y++) {
				ans = Math.max(ans, dist[x][y]-1);
				if (grid[x][y] == 0 && dist[x][y] == 0) {
					ans = -1;
					break;
				}
			}
			
			if (ans == -1) break;
		}
		
		System.out.println(ans);
	}
}
