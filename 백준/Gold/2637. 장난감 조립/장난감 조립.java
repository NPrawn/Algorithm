import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static class Edge {
        int to, k;

        Edge(int to, int k) {
            this.to = to;
            this.k = k;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());

        ArrayList<Edge>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        int[] indeg = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            g[y].add(new Edge(x, k));
            indeg[x]++;
        }

        long[][] need = new long[n + 1][n + 1];
        boolean[] isBasic = new boolean[n + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                isBasic[i] = true;
                need[i][i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge e : g[cur]) {
                int next = e.to;
                int k = e.k;

                for (int b = 1; b <= n; b++) {
                    if (need[cur][b] == 0) continue;
                    need[next][b] += need[cur][b] * k;
                }

                indeg[next]--;
                if (indeg[next] == 0) q.add(next);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (isBasic[i]) {
                sb.append(i).append(' ').append(need[n][i]).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}