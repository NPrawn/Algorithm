import java.io.*;
import java.util.*;

public class Main {
    private static int[] board, dist;
    private static int n, k;
    private static boolean[] vis;
    private static int[] dx = {0, -1, 1};

    public static int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        vis[n] = true;
        if (n == k) {
            return 0;
        }
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int dir = 0; dir < 3; dir++) {
                if (dir == 0) {
                    int nx = cur * 2;
                    if (nx < 0 || nx > 100000) continue;
                    if (nx == k) {
                        return dist[cur];
                    }
                    if (vis[nx]) continue;
                    que.add(nx);
                    vis[nx] = true;
                    dist[nx] = dist[cur];
                } else {
                    int nx = cur + dx[dir];
                    if (nx < 0 || nx > 100000) continue;
                    if (nx == k) {
                        return dist[cur] + 1;
                    }
                    if(vis[nx]) continue;
                    que.add(nx);
                    vis[nx] = true;
                    dist[nx] = dist[cur] + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[100010];
        vis = new boolean[100010];
        dist = new int[100010];
        int res = bfs();

        bw.write(res + "\n");


        br.close();
        bw.close();
    }
}