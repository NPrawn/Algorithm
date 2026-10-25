import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, d;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        List<int[]>[] adj = new ArrayList[n+1];

        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[u].add(new int[] {d, v});
            adj[v].add(new int[] {d, u});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        int[] dist = new int[n+1];
        for (int i=0; i<=n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[n] = 0;
        pq.add(new int[] {0, n});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int w = now[0];
            int cur = now[1];
            
            if (w != dist[cur]) continue;
            
            for (int[] next : adj[cur]) {
                int nw = next[0];
                int nxt = next[1];
                if (dist[nxt] <= dist[cur] + nw) continue;
                dist[nxt] = dist[cur] + nw;
                pq.add(new int[] {dist[nxt], nxt});
            }
        }

        int ans = 0;
        for (int i=0; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) continue;
            ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans);
    }
}