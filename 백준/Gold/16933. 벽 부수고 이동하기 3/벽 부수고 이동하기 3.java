import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int board[][];
    static boolean vis[][][];

    static class Node {
        int x;
        int y;
        int h;
        int dist;
        boolean day;

        public Node(int h, int x, int y, int dist, boolean day) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.day = day;
        }
    }

    public static Node bfs() {
        Queue<Node> que = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        que.add(new Node(0, 0, 0, 1, true));
        vis[0][0][0] = true;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur;
            }
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (vis[cur.h][nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    if (cur.h >= k) {
                        continue;
                    }
                    if (vis[cur.h + 1][nx][ny]) {
                        continue;
                    }
                    if (cur.day) {
                        que.add(new Node(cur.h + 1, nx, ny, cur.dist + 1, !cur.day));
                        vis[cur.h + 1][nx][ny] = true;
                    } else {
                        que.add(new Node(cur.h, cur.x, cur.y, cur.dist + 1, !cur.day));
                    }
                } else {
                    que.add(new Node(cur.h, nx, ny, cur.dist + 1, !cur.day));
                    vis[cur.h][nx][ny] = true;
                }
            }
        }


        return new Node(-1, -1, -1, -1, false);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        vis = new boolean[k + 1][n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        Node ans = bfs();

        bw.write(ans.dist + "\n");

        br.close();
        bw.close();
    }
}