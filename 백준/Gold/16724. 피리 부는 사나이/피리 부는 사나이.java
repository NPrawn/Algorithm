import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static char[][] grid;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashMap<Character, Integer> dict = new HashMap<>();
    static int[] parent;
    static int ans;

    public static void main(String[] args) throws Exception {
        dict.put('D', 0);
        dict.put('L', 3);
        dict.put('R', 1);
        dict.put('U', 2);
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n * m];
        ans = n * m;
        for (int i=0; i< parent.length; i++) parent[i] = i;

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nx = i + dx[dict.get(grid[i][j])];
                int ny = j + dy[dict.get(grid[i][j])];
                union(i * m + j, nx * m + ny);
            }
        }

        System.out.println(ans);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;
        if (x <= y) parent[y] = x;
        else parent[x] = y;
        ans -= 1;
        return true;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}