import java.util.*;
import java.io.*;

public class Main {
    static int k, n, m, ans, board[][];
    static boolean vis[][][];

    static class Node {
        int x;
        int y;
        int cnt;
        int horse;

        public Node(int x, int y, int cnt, int horse) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.horse = horse;
        }
    }

    static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[] hdx = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] hdy = {1, -1, 1, -1, 2, -2, 2, -2};
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0, 0, 0, k));
        vis[0][0][k] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.cnt;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (vis[nx][ny][cur.horse] || board[nx][ny] == 1) {
                    continue;
                }
                que.offer(new Node(nx, ny, cur.cnt + 1, cur.horse));
                vis[nx][ny][cur.horse] = true;
            }

            if (cur.horse == 0) {
                continue;
            }
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + hdx[dir];
                int ny = cur.y + hdy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (vis[nx][ny][cur.horse - 1] || board[nx][ny] == 1) {
                    continue;
                }
                que.offer(new Node(nx, ny, cur.cnt + 1, cur.horse - 1));
                vis[nx][ny][cur.horse - 1] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        vis = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = bfs();
        bw.write(ans + "\n");


        br.close();
        bw.close();
    }
}