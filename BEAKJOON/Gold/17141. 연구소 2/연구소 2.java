import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] dist;
    static int[] arr;
    static boolean[] isUsed;
    static ArrayList<Node> location = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

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
        for (int i = 0; i < location.size(); i++) {
            if (isUsed[i]) continue;
            if (cur > 0 && arr[cur - 1] > i) continue;
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
        for (int e : arr) {
            q.offer(location.get(e));
            dist[location.get(e).x][location.get(e).y] = 1;
        }
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny)) continue;
                if (dist[nx][ny] > 0) continue;
                if (map[nx][ny] == 1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                max = Math.max(dist[cur.x][cur.y], max);
                q.offer(new Node(nx, ny));
            }
        }
        boolean check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) continue;
                if (dist[i][j] == 0) {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            ans = Math.min(max, ans);
        }
    }

    static boolean OOB(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        arr = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    location.add(new Node(i, j));
                }
            }
        }
        isUsed = new boolean[location.size()];

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