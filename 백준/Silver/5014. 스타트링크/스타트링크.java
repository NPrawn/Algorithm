import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int f,s,g,u,d;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        dist = new int[f + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            int nx = now + u;
            if (nx <= f && dist[nx] == -1) {
                q.add(nx);
                dist[nx] = dist[now] + 1;
            }

            nx = now - d;
            if (nx > 0 && dist[nx] == -1) {
                q.add(nx);
                dist[nx] = dist[now] + 1;
            }
        }

        System.out.println(dist[g] != -1 ? dist[g] : "use the stairs");
    }
}