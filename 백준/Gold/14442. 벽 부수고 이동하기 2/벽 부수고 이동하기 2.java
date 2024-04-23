import org.w3c.dom.Node;

import java.io.*;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int board[][];
    static boolean vis[][][];

    public static class Node {
        int x;
        int y;
        int h;
        int dist;

        public Node(int x, int y, int h, int dist) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.dist = dist;
        }
    }

    public static Node bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 0, 1));
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
                if (cur.h < k - 1) {
                    if (board[nx][ny] == 1) {
                        if (vis[cur.h + 1][nx][ny]) {
                            continue;
                        }
                        que.add(new Node(nx, ny, cur.h + 1, cur.dist + 1));
                        vis[cur.h + 1][nx][ny] = true;
                    } else {
                        que.add(new Node(nx, ny, cur.h, cur.dist + 1));
                        vis[cur.h][nx][ny] = true;
                    }
                } else {
                    if (board[nx][ny] == 1) {
                        continue;
                    } else {
                        que.add(new Node(nx, ny, cur.h, cur.dist + 1));
                        vis[cur.h][nx][ny] = true;
                    }
                }
            }
        }

        return new Node(-1, -1, -1, -1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) + 1;
        board = new int[n][m];
        vis = new boolean[k][n][m];

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