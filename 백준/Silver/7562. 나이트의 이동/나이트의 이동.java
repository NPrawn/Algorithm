import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		while (T-- > 0) {
			int n = Integer.parseInt(input.readLine());
			int[][] dist = new int[n][n];
			st = new StringTokenizer(input.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(input.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			dist[sx][sy] = 1;
			ArrayDeque<int[]> dq = new ArrayDeque<>();
			dq.add(new int[] {sx,sy});
			
			while (!dq.isEmpty()) {
				int[] now = dq.pollFirst();
				int x = now[0];
				int y = now[1];
				for (int d=0; d<8; d++) {
					int nx = x+ dx[d];
					int ny = y + dy[d];
					if (nx<0 || ny <0 || nx>=n || ny>=n) continue;
					if (dist[nx][ny] != 0) continue;
					dq.add(new int[] {nx,ny});
					dist[nx][ny] = dist[x][y] + 1;
				}
			}
			
			System.out.println(dist[ex][ey] - 1);
		}
	}
}
