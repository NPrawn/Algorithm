import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{w, v});
        }

        st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dist = new int[n+1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);
        dist[a] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, a});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int w = now[0];
            int u = now[1];
            if (w != dist[u]) continue;

            for (int[] nxt : adj[u]) {
                int nw = nxt[0];
                int v = nxt[1];

                if (dist[v] <= dist[u] + nw) continue;
                dist[v] = dist[u] + nw;
                pq.add(new int[]{dist[v], v});
            }
        }

        System.out.println(dist[b]);
    }
}