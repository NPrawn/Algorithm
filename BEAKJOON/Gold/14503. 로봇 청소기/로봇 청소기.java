import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r, c, d, ans = 0;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Node robot;
    static boolean[][] vis;

    static class Node {
        int x, y, d;

        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static void rotate() {
        robot.d--;
        if (robot.d == -1) robot.d = 3;
    }

    static void run() {
        while (true) {
            if (map[robot.x][robot.y] == 0 && !vis[robot.x][robot.y]) {
                vis[robot.x][robot.y] = true;
                ans++;
            }
            boolean isVis = false;
            for (int dir = 0; dir < 4; dir++) {
                int nx = robot.x + dx[dir];
                int ny = robot.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vis[nx][ny]) continue;
                if (map[nx][ny] == 1) continue;
                isVis = true;
                break;
            }
            if (isVis) {
                while (true) {
                    rotate();
                    int nx = robot.x - dx[robot.d];
                    int ny = robot.y - dy[robot.d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (vis[nx][ny]) continue;
                    if (map[nx][ny] == 1) continue;
                    robot.x = nx;
                    robot.y = ny;
                    break;
                }
            } else {
                int nx = robot.x + dx[robot.d];
                int ny = robot.y + dy[robot.d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) return;
                if (map[nx][ny] == 1) return;
                robot.x = nx;
                robot.y = ny;
            }


        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vis = new boolean[n][m];
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        robot = new Node(r, c, d);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run();

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}