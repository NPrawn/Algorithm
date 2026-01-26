import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static List<Integer>[] adj;
    static boolean[] vis;
    static boolean ans;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vis = new boolean[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int start = 0; start < n; start++) {
            vis[start] = true;
            dfs(start, 0);
            vis[start] = false;
        }

        System.out.println(ans ? 1 : 0);

    }

    static void dfs(int cur, int depth) {
        if (ans) return;
        if (depth == 4) {
            ans = true;
            return;
        }

        for (int nxt : adj[cur]) {
            if (vis[nxt]) continue;
            vis[nxt] = true;
            dfs(nxt, depth + 1);
            vis[nxt] = false;
        }
    }

}