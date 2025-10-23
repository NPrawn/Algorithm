import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int rx, ry;
        int bx, by;
        int ct;

        Node(int rx, int ry, int bx, int by, int ct) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.ct = ct;
        }
    }

    static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.ct == 10) {
                continue;
            }
            for (int dir = 0; dir < 4; dir++) {
                int rx = cur.rx;
                int ry = cur.ry;
                int bx = cur.bx;
                int by = cur.by;
                boolean redHole = false;
                boolean blueHole = false;
                while (true) {
                    int nrx = rx + dx[dir];
                    int nry = ry + dy[dir];
                    if (board[nrx][nry] == '#') {
                        break;
                    }
                    if (board[nrx][nry] == 'O') {
                        redHole = true;
                        break;
                    }
                    rx = nrx;
                    ry = nry;
                }
                while (true) {
                    int nbx = bx + dx[dir];
                    int nby = by + dy[dir];
                    if (board[nbx][nby] == '#') {
                        break;
                    }
                    if (board[nbx][nby] == 'O') {
                        blueHole = true;
                        break;
                    }
                    bx = nbx;
                    by = nby;
                }

                if (blueHole) continue;
                else if (redHole) {
                    return cur.ct + 1;
                }

                if (cur.rx == rx && cur.ry == ry && cur.bx == bx && cur.by == by) {
                    continue;
                }

                if (rx == bx && ry == by) {
                    if (dir == 0) {
                        if (cur.rx < cur.bx) {
                            rx--;
                        } else {
                            bx--;
                        }
                    } else if (dir == 1) {
                        if (cur.rx < cur.bx) {
                            bx++;
                        } else {
                            rx++;
                        }
                    } else if (dir == 2) {
                        if (cur.ry < cur.by) {
                            ry--;
                        } else {
                            by--;
                        }
                    } else if (dir == 3) {
                        if (cur.ry < cur.by) {
                            by++;
                        } else {
                            ry++;
                        }
                    }
                }

                q.offer(new Node(rx, ry, bx, by, cur.ct + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        Node node = new Node(0, 0, 0, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    node.rx = i;
                    node.ry = j;
                    board[i][j] = '.';
                }
                if (board[i][j] == 'B') {
                    node.bx = i;
                    node.by = j;
                    board[i][j] = '.';
                }
            }
        }


        sb.append(bfs(node));
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}