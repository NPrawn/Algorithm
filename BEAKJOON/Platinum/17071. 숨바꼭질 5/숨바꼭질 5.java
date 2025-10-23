import org.w3c.dom.Node;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean[][] vis;
    static int[] dx = {-1, 1};

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        vis[0][n] = true;
        q.offer(n);

        if (n == k) {
            return 0;
        }

        int size, flag, time = 0;
        while (!q.isEmpty()) {
            size = q.size();
            time++;
            flag = time % 2;

            k += time;
            if (k > 500000) {
                return -1;
            }

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int dir = 0; dir < 3; dir++) {
                    int nx;
                    if (dir == 2) {
                        nx = cur * 2;
                    } else {
                        nx = cur + dx[dir];
                    }

                    if (nx < 0 || nx > 500000 || vis[flag][nx]) {
                        continue;
                    }
                    q.offer(nx);
                    vis[flag][nx] = true;
                }
            }
            if (vis[flag][k]) {
                return time;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        vis = new boolean[2][500001];

        bw.write(bfs() + "\n");

        bw.close();
        br.close();
    }
}