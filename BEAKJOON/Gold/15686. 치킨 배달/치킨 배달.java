import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, size, tmp, homesize;
    static long ans = Long.MAX_VALUE;
    static int[][] board;
    static ArrayList<Node> ch = new ArrayList<>();
    static boolean[] isUsed;
    static int[] arr;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    static boolean[][] vis;
    static ArrayList<Node> home = new ArrayList<>();

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny]) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                vis[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
    }

    static void combi(int cur) {
        if (cur == m) {
            tmp = 0;
            q.clear();
            dist = new int[n][n];
            vis = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                Node e = ch.get(arr[i]);
                q.offer(e);
                vis[e.x][e.y] = true;
            }
            bfs();
            for (Node e : home) {
                tmp += dist[e.x][e.y];
            }
            ans = Math.min(ans, tmp);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (isUsed[i]) continue;
            if (cur != 0 && arr[cur - 1] > i) continue;
            isUsed[i] = true;
            arr[cur] = i;
            combi(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        arr = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    ch.add(new Node(i, j));
                }
                if (board[i][j] == 1) {
                    home.add(new Node(i, j));
                }
            }
        }
        size = ch.size();
        homesize = home.size();
        isUsed = new boolean[size];

        combi(0);


        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}