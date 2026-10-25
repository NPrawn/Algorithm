import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n+1];
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            parent[c] = p;
            adj[p].add(c);
        }

        int root = 0;
        for (int i=1; i<=n; i++) {
            if (parent[i] == 0) root = i;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int[] depth = new int[n+1];
        dq.offerLast(root);
        while (!dq.isEmpty()) {
            int now = dq.pollFirst();
            for (int nxt : adj[now]) {
                depth[nxt] = depth[now] + 1;
                dq.offerLast(nxt);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        System.out.println(a);
    }
}