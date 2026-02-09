import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int x;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] adj1 = new ArrayList[n + 1];
        ArrayList<int[]>[] adj2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj1[i] = new ArrayList<>();
            adj2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj1[a].add(new int[]{w, b});
            adj2[b].add(new int[]{w, a});
        }

        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dijk(dist1, adj1);
        dijk(dist2, adj2);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);
    }

    private static void dijk(int[] dist, ArrayList<int[]>[] adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, x});
        dist[x] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0];
            int now = cur[1];

            if (w != dist[now]) {
                continue;
            }

            for (int[] next : adj[now]) {
                int nw = next[0];
                int nxt = next[1];
                if (dist[nxt] <= dist[now] + nw) {
                    continue;
                }

                dist[nxt] = dist[now] + nw;
                pq.add(new int[]{dist[nxt], nxt});
            }
        }


    }
}