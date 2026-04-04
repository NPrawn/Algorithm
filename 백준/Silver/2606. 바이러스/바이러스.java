import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        q.add(1);
        int ans = 0;

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            for (int a : adj[now]) {
                if (vis[a]) continue;
                q.add(a);
                ans+=1;
                vis[a] = true;
            }
        }

        System.out.println(ans);
    }
}