import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, ans = 0;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean check = true;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        int sum;
        Queue<Node> q = new LinkedList<>();

        while (check) {
            boolean[][] vis = new boolean[n][n];
            check = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (vis[i][j]) continue;
                    ArrayList<Node> union = new ArrayList<>();
                    sum = 0;
                    union.add(new Node(i, j));
                    q.offer(new Node(i, j));
                    vis[i][j] = true;
                    while (!q.isEmpty()) {
                        Node cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (vis[nx][ny]) continue;
                            int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);
                            if (diff > r || diff < l) continue;
                            union.add(new Node(nx, ny));
                            vis[nx][ny] = true;
                            q.offer(new Node(nx, ny));
                        }
                    }
                    if (union.size() > 1) {
                        check = true;
                        for (Node e : union) {
                            sum += map[e.x][e.y];
                        }
                        sum /= union.size();
                        for (Node e : union) {
                            map[e.x][e.y] = sum;
                        }
                    }

                }
            }
            ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        sb.append(ans - 1);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}