import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] dist;
    static int[] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] isUsed;
    static ArrayList<Node> virus = new ArrayList<>();

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void combination(int cur) {
        if (cur == m) {
            bfs();
            return;
        }
        for (int i = 0; i < virus.size(); i++) {
            if (isUsed[i]) continue;
            if (cur != 0 && arr[cur - 1] > i) continue;
            arr[cur] = i;
            isUsed[i] = true;
            combination(cur + 1);
            isUsed[i] = false;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        dist = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int e : arr) {
            q.offer(new Node(virus.get(e).x, virus.get(e).y));
            dist[virus.get(e).x][virus.get(e).y]++;
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (dist[nx][ny] != -1) continue;
                if (map[nx][ny] == 1) continue;
                if (!(map[nx][ny] == 2 && dist[nx][ny] == -1)) {
                    max = Math.max(max, dist[cur.x][cur.y] + 1);
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Node(nx, ny));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && dist[i][j] == -1) {
                    return;
                }
            }
        }
        ans = Math.min(ans, max);

    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        isUsed = new boolean[virus.size()];
        combination(0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}