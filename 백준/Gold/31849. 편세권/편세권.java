import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, board[][];
    static Node room[];
    static boolean vis[][];
    static int dist[][];
    static Queue<Node> q = new LinkedList<>();
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        int p;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny]) continue;
                vis[nx][ny] = true;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny, cur.p));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n++;
        m++;
        board = new int[n][m];
        vis = new boolean[n][m];
        dist = new int[n][m];
        room = new Node[r];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            room[i] = new Node(x, y, p);
        }

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.offer(new Node(x, y));
            vis[x][y] = true;
        }

        bfs();

        int min = Integer.MAX_VALUE;
        for (Node r : room) {
            int tmp = dist[r.x][r.y] * r.p;
            if (tmp < min) {
                min = tmp;
            }
        }

        sb.append(min);

        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}