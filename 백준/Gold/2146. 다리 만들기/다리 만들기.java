import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board, dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] vis;

    public static class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void setLand() {
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] || board[i][j] == 0) continue;
                Queue<Pair> que = new LinkedList<>();
                que.add(new Pair(i, j));
                vis[i][j] = true;
                while (!que.isEmpty()) {
                    Pair cur = que.poll();
                    board[cur.x][cur.y] = idx;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (vis[nx][ny] || board[nx][ny] == 0) continue;
                        que.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                    }
                }
                idx++;
            }
        }
    }

    public static void bridge() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        board = new int [n][n];
        dist = new int[n][n];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
            }
        }
        setLand();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    dist[i][j] = 0;
                    que.add(new Pair(i, j));
                }
            }
        }
        int ans = n * n;
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == board[cur.x][cur.y]) continue;
                if (board[nx][ny] != 0) {
                    ans = Math.min(ans, dist[nx][ny] + dist[cur.x][cur.y]);
                } else {
                    board[nx][ny] = board[cur.x][cur.y];
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    que.add(new Pair(nx, ny));
                }
            }
        }

        bw.write(ans + "\n");

        br.close();
        bw.close();
    }
}