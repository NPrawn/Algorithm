import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int t, n, m, ct = 0;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static boolean key[];
    static char board[][];
    static Queue<Node> door[], q;
    static boolean vis[][];


    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs() {
        q.offer(new Node(0, 0));
        vis[0][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vis[nx][ny] || board[nx][ny] == '*') continue;
                vis[nx][ny] = true;

                if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z') {
                    int k = board[nx][ny] - 'a';
                    key[k] = true;
                    while (!door[k].isEmpty()) {
                        Node ndoor = door[k].poll();
                        q.offer(new Node(ndoor.x, ndoor.y));
                    }
                } else if (board[nx][ny] >= 'A' && board[nx][ny] <= 'Z') {
                    int k = board[nx][ny] + 32 - 'a';
                    if (!key[k]) {
                        door[k].offer(new Node(nx, ny));
                        continue;
                    }
                } else if (board[nx][ny] == '$') {
                    ct++;
                }
                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ct = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()) + 2;
            m = Integer.parseInt(st.nextToken()) + 2;
            board = new char[n][m];
            vis = new boolean[n][m];
            q = new LinkedList<>();

            door = new Queue[26];
            for (int i = 0; i < 26; i++) {
                door[i] = new LinkedList<>();
            }

            for (int i = 1; i < n - 1; i++) {
                String s = br.readLine();
                for (int j = 1; j < m - 1; j++) {
                    board[i][j] = s.charAt(j - 1);
                }
            }

            key = new boolean[26];
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.equals("0")) {
                    break;
                }
                key[s.charAt(i) - 'a'] = true;
            }

            bfs();
            bw.write(ct + "\n");
        }


        br.close();
        bw.close();
    }
}