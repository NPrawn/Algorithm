import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n = 5;
    static int[][][] maze;
    static int[][][] maze1;
    static int[][][] board = new int[5][5][5];
    static int ans = Integer.MAX_VALUE;
    static int[] sx = {0, 4, 0, 4};
    static int[] sy = {0, 0, 4, 4};
    static int[] sz = {0, 0, 0, 0};
    static int[] ex = {4, 0, 4, 0};
    static int[] ey = {4, 4, 0, 0};
    static int[] ez = {4, 4, 4, 4};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static boolean[] isUsed = new boolean[5];
    static int[] arr = new int[5];

    static class Node {
        int z, x, y;

        Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        for (int t = 0; t < 4; t++) {
            Node start = new Node(sz[t], sx[t], sy[t]);
            Node end = new Node(ez[t], ex[t], ey[t]);
            if (maze1[start.z][start.x][start.y] == 0) return;
            if (maze1[end.z][end.x][end.y] == 0) return;
            Queue<Node> q = new LinkedList<>();
            boolean[][][] vis = new boolean[n][n][n];
            int[][][] dist = new int[5][5][5];
            vis[start.z][start.x][start.y] = true;
            q.offer(new Node(start.z, start.x, start.y));
            while (!q.isEmpty()) {
                Node cur = q.poll();
                for (int dir = 0; dir < 6; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    int nz = cur.z + dz[dir];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= n || nz >= n) continue;
                    if (vis[nz][nx][ny]) continue;
                    if (maze1[nz][nx][ny] == 0) continue;
                    if (nx == end.x && ny == end.y && nz == end.z) {
                        ans = Math.min(ans, dist[cur.z][cur.x][cur.y] + 1);
                        return;
                    }
                    q.offer(new Node(nz, nx, ny));
                    vis[nz][nx][ny] = true;
                    dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                }
            }
        }
    }

    static void rotate(int idx) {
        int[][][] tmp = new int[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp[idx][j][5 - i - 1] = maze1[idx][i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maze1[idx][i][j] = tmp[idx][i][j];
            }
        }
    }

    static void run() {
        for (int i = 0; i < 1024; i++) {
            int brute = i;
            for (int q = 0; q < 5; q++) {
                for (int w = 0; w < 5; w++) {
                    for (int e = 0; e < 5; e++) {
                        maze1[q][w][e] = maze[q][w][e];
                    }
                }
            }
            for (int j = 0; j < 5; j++) {
                int p = brute % 4;
                for (int k = 0; k < p; k++) {
                    rotate(j);
                }
                brute /= 4;
            }
            bfs();
            if (ans == 12) {
                return;
            }
        }
    }

    static void permutation(int cur) {
        if (cur == 5) {
            int idx = 0;
            for (int z : arr) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        maze[idx][i][j] = board[z][i][j];
                    }
                }
                idx++;
            }
            run();
        }
        for (int i = 0; i < 5; i++) {
            if (isUsed[i]) continue;
            arr[cur] = i;
            isUsed[i] = true;
            permutation(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];
        maze1 = new int[5][5][5];

        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    int e = Integer.parseInt(st.nextToken());
                    board[k][i][j] = e;
                    maze[k][i][j] = e;
                    maze1[k][i][j] = e;
                }
            }
        }

        permutation(0);

        if (ans == Integer.MAX_VALUE) ans = -1;

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}