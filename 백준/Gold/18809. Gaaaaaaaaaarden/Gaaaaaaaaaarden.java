import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, m,g,r;
	static int[][] grid;
	static ArrayList<int[]> arr = new ArrayList<>();
	static boolean used[];
	static ArrayList<int[]> G = new ArrayList<>();
	static ArrayList<int[]> R = new ArrayList<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(input.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		grid = new int[n][m];
		for (int x=0;x<n;x++) {
			st = new StringTokenizer(input.readLine());
			for (int y=0;y<m;y++) {
				grid[x][y] = Integer.parseInt(st.nextToken());
				if (grid[x][y] == 2) arr.add(new int[] {x,y});
			}
		}
		
		used = new boolean[arr.size()];
		solve(0,0,0);
		System.out.println(ans);
	}
	
	static void solve(int idx, int cg, int cr) {
	    if (cg > g || cr > r) return;

	    if (idx == arr.size()) {
	        if (cg == g && cr == r) ans = Math.max(ans, bfs());
	        return;
	    }

	    int remain = arr.size() - idx;
	    if (cg + remain < g) return;
	    if (cr + remain < r) return;

	    solve(idx + 1, cg, cr);

	    if (cg < g) {
	        G.add(arr.get(idx));
	        solve(idx + 1, cg + 1, cr);
	        G.remove(G.size() - 1);
	    }

	    if (cr < r) {
	        R.add(arr.get(idx));
	        solve(idx + 1, cg, cr + 1);
	        R.remove(R.size() - 1);
	    }
	}
	
	static int bfs() {
		int[][] color = new int[n][m];
		int[][] time = new int[n][m];
		for (int i = 0; i < n; i++) Arrays.fill(time[i], -1);

		ArrayDeque<int[]> q = new ArrayDeque<>();

		for (int[] p : G) {
			int x = p[0], y = p[1];
			color[x][y] = 1;
			time[x][y] = 0;
			q.add(new int[] { x, y, 1 });
		}
		for (int[] p : R) {
			int x = p[0], y = p[1];
			color[x][y] = 2;
			time[x][y] = 0;
			q.add(new int[] { x, y, 2 });
		}

		int flower = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1], c = cur[2];

			if (color[x][y] == 3) continue;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (grid[nx][ny] == 0) continue;

				if (color[nx][ny] == 0) {
					color[nx][ny] = c;
					time[nx][ny] = time[x][y] + 1;
					q.add(new int[] { nx, ny, c });
				}
				else if (color[nx][ny] != 3 && color[nx][ny] != c && time[nx][ny] == time[x][y] + 1) {
					color[nx][ny] = 3;
					flower++;
				}
			}
		}

		return flower;
	}
}