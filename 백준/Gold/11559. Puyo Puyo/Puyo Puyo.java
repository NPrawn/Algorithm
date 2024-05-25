import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board;
    static int ans = 0;
    static boolean isPop = false;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y;
        char c;

        Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        board = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        while (true) {
            isPop = false;
            bfs();
            onFloor();
            if (!isPop) {
                break;
            }
            ans++;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean vis[][] = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] == '.' || vis[i][j]) continue;
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[]{i, j});
                q.offer(new Node(i, j, board[i][j]));
                vis[i][j] = true;

                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = cur.x + dx[dir];
                        int ny = cur.y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                        if (vis[nx][ny] || board[nx][ny] != cur.c) continue;
                        q.offer(new Node(nx, ny, board[nx][ny]));
                        list.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                if (list.size() >= 4) {
                    for (int k = 0; k < list.size(); k++) {
                        int x = list.get(k)[0];
                        int y = list.get(k)[1];

                        board[x][y] = '.';
                        isPop = true;
                    }
                }
            }
        }
    }

    static void onFloor() {
        for (int j = 0; j < 6; j++) {
            down(j);
        }
    }

    static void down(int j) {
        Queue<Node> node = new LinkedList<>();
        int idx = 11;

        for (int i = 11; i >= 0; i--) {
            if (board[i][j] != '.') {
                node.offer(new Node(i, j, board[i][j]));
                board[i][j] = '.';
            }
        }

        while (!node.isEmpty()) {
            Node n = node.poll();
            char color = n.c;
            board[idx][j] = color;

            idx--;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}