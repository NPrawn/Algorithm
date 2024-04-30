import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class Main {
    static int r, c, lx, ly, cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean vis[][];
    static boolean visit[][];
    static char[][] board;
    static boolean isPossible = false;
    static Queue<Node> q;
    static Queue<Node> q2;
    static Queue<Node> lq;
    static Queue<Node> lq2;

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean OOB(int a, int b) {
        return a < 0 || a >= r || b < 0 || b >= c;
    }

    public static void bfsX() {
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visit[cur.x][cur.y] = true;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny) || visit[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] == 'X') {
                    q2.offer(new Node(nx, ny));
                }
                visit[nx][ny] = true;
            }
        }
        while (!q2.isEmpty()) {
            Node cur = q2.poll();
            board[cur.x][cur.y] = '.';
            q.offer(new Node(cur.x, cur.y));

        }
    }

    public static boolean bfsL() {
        while (!lq.isEmpty()) {
            Node cur = lq.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (OOB(nx, ny) || vis[nx][ny]) continue;
                if (board[nx][ny] == 'X') {
                    vis[nx][ny] = true;
                    lq2.offer(new Node(nx, ny));
                    continue;
                } else if (board[nx][ny] == 'L') {
                    return false;
                }
                vis[nx][ny] = true;
                lq.offer(new Node(nx, ny));
            }
        }
        while (!lq2.isEmpty()) {
            lq.offer(lq2.poll());
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        vis = new boolean[r][c];
        visit = new boolean[r][c];
        q = new LinkedList<>();
        q2 = new LinkedList<>();
        lq = new LinkedList<>();
        lq2 = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
                if (board[i][j] != 'X') {
                    q.offer(new Node(i, j));
                }
            }
        }
        lq.offer(new Node(lx, ly));
        board[lx][ly] = '.';
        vis[lx][ly] = true;

        while (bfsL()) {
            bfsX();
            cnt++;
        }

        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}
