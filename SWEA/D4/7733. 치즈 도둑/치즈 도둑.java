import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] grid;
    static int n;
    
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(input.readLine());
            grid = new int[n][n];
            for (int i=0;i<n;i++) {
            	st = new StringTokenizer(input.readLine());
            	for (int j=0;j<n;j++) {
            		grid[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            int ans = 1;
            for (int t=0; t<100;t++) {
            	simul();
            	ans = Math.max(ans, bfs());
            }
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
    
    static void simul() {
    	for (int x=0; x<n;x++) {
    		for (int y=0; y<n;y++) {
    			grid[x][y] -= 1;
    		}
    	}
    }
    
    static int bfs() {
    	boolean[][] vis = new boolean[n][n];
    	int ct = 0;
    	for (int x=0; x<n; x++) {
    		for (int y=0; y<n; y++) {
    			if (vis[x][y]) continue;
    			if (grid[x][y] <= 0) continue;
    			ArrayDeque<int[]> dq = new ArrayDeque<>();
    			dq.add(new int[] {x, y});
    			ct += 1;
    			while (!dq.isEmpty()) {
    				int[] cur = dq.pollFirst();
    				for (int d=0; d<4; d++) {
    					int nx = cur[0]+dx[d];
    					int ny = cur[1]+dy[d];
    					
    					if (nx<0 || nx>=n || ny<0 || ny>= n) continue;
    					if (grid[nx][ny] <= 0) continue;
    					if (vis[nx][ny]) continue;
    					vis[nx][ny] = true;
    					dq.add(new int[] {nx,ny});
    				}
    			}
    		}
    	}
    	
    	return ct;
    }
}
