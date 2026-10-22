import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] grid;
    static int n;
    static int ans = Integer.MIN_VALUE;
    static int[] used;

    static void dfs(int depth, int min) {
        if (depth == n) {
            ans = Math.max(ans, min);
            return;
        }

        for (int i=0; i<n; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            dfs(depth + 1, Math.min(min, grid[depth][i]));
            used[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        used = new int[n];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, Integer.MAX_VALUE);

        System.out.println(ans);
    }
}