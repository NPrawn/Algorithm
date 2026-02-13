import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

            int[] deg = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                deg[b]++;
            }

            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if (deg[i] == 0) q.add(i);
            }

            ArrayList<Integer> ans = new ArrayList<>();
            while (!q.isEmpty()) {
                int now = q.poll();
                ans.add(now);
                for (int nxt : adj[now]) {
                    deg[nxt]--;
                    if (deg[nxt] == 0) q.add(nxt);
                }
            }

            sb.append('#').append(tc).append(' ');
            for (int i =0; i<ans.size(); i++) {
            	sb.append(ans.get(i)).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
