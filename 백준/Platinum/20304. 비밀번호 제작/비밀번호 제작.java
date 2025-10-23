import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, dist[];
    static Queue<Integer> q = new LinkedList<>();

    public static int bfs() {
        int safety = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 20; i++) {
                int nx = cur ^ (1 << i);
                if (nx > n || dist[nx] >= 0) continue;
                q.offer(nx);
                dist[nx] = dist[cur] + 1;
                safety = dist[nx];
            }
        }
        return safety;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int p = Integer.parseInt(st.nextToken());
            q.offer(p);
            dist[p] = 0;
        }

        bw.write(bfs() + "\n");



        br.close();
        bw.close();
    }
}