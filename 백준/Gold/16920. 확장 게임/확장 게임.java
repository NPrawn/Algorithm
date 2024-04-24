import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static char[][] board;
    static int[] player;
    static Queue<Node>[] qs;
    static int[] res;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(Queue<Node> q, int turn) {
        int cnt = 0;
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (board[nx][ny] != '.') continue;
                    q.add(new Node(nx, ny));
                    board[nx][ny] = board[cur.x][cur.y];
                    res[turn]++;
                    cnt++;
                }
            }
            dist++;
            if (dist > player[turn]) break;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        player = new int[k + 1];
        res = new int[k + 1];
        qs = new LinkedList[k + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= k; i++) {
            player[i] = Integer.parseInt(st.nextToken());
            qs[i] = new LinkedList<>();
        }

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                if (ch >= '0' && ch <= '9') {
                    int p = ch - '0';
                    res[p]++;
                    qs[p].offer(new Node(i, j));
                }
                board[i][j] = ch;
            }
        }
        int turn = 1;
        int round = 0;
        while (true) {
            int cnt = bfs(qs[turn], turn);
            turn++;
            round += cnt;
            if (turn == k + 1) {
                if (round == 0) break;
                turn = 1;
                round = 0;
            }
        }

        for (int i = 1; i <= k; i++) {
            bw.write(res[i] + " ");
        }

        br.close();
        bw.close();
    }
}