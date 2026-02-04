import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] dx = {0,0,-1};
	static int[] dy = {-1,1,0};

	public static void main(String[] args) throws Exception {
		int T = 10;
		while (T-- > 0) {
			int t = Integer.parseInt(input.readLine());
			int n = 100;
			int[][] grid = new int[n][n];
			boolean[][] vis = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(input.readLine());
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Deque<int[]> dq = new ArrayDeque<>();
			for (int i=0; i<n; i++) {
				if (grid[99][i] == 2) {
					dq.addLast(new int[] {99, i});
					vis[99][i] = true;
				}
			}
			
			int ans = 0;
			while (!dq.isEmpty()) {
				int[] now = dq.pollFirst();
				int x = now[0];
				int y = now[1];
				
				for (int d=0; d<3;d++) {
					int nx = x+ dx[d];
					int ny = y+dy[d];
					
					if (nx<0 || nx >= n || ny <0 || ny>=n) continue;
					if (vis[nx][ny]) continue;
					if (grid[nx][ny] == 0) continue;
					vis[nx][ny] = true;
					dq.addLast(new int[] {nx,ny});
					break;
				}
				
				if (x==0) ans = y;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}