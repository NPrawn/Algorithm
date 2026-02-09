import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        int[] path = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{w, b});
        }

        st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, a});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[a] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0];
            int now = cur[1];

            if (w != dist[now]) continue;
            for (int[] next : adj[now]) {
                int nw = next[0];
                int nxt = next[1];
                if (dist[nxt] <= dist[now] + nw) continue;
                dist[nxt] = dist[now] + nw;
                pq.add(new int[]{dist[nxt], nxt});
                path[nxt] = now;
            }
        }

        sb.append(dist[b]).append("\n");
        ArrayList<Integer> ans = new ArrayList<>();
        while (b != a) {
            ans.add(b);
            b = path[b];
        }
        ans.add(b);
        Collections.reverse(ans);
        sb.append(ans.size()).append("\n");
        for (int e : ans) {
            sb.append(e).append(" ");
        }
        System.out.println(sb.toString());
    }
}