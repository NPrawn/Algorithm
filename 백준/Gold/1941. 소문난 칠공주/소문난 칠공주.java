import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board;
    static int ans = 0;
    static int[] arr;
    static boolean[] isUsed;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int[] arr) {
        Queue<Node> q = new LinkedList<>();
        boolean isp[][] = new boolean[5][5];
        boolean vis[][] = new boolean[5][5];
        for (int e : arr) {
            int x = e / 5;
            int y = e % 5;
            if (q.isEmpty()) {
                q.offer(new Node(x, y));
                vis[x][y] = true;
            }
            isp[x][y] = true;
        }
        int total = 0;
        int ctS = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (board[cur.x][cur.y] == 'S') ctS++;
            total++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (!isp[nx][ny] || vis[nx][ny]) continue;
                q.offer(new Node(nx, ny));
                vis[nx][ny] = true;
            }
        }
        if (total == 7 && ctS >= 4) {
            ans++;
        }
    }

    public static void func(int cur) {
        if (cur == 7) {
            bfs(arr);
            return;
        }
        for (int i = 0; i < 25; i++) {
            if (isUsed[i]) continue;
            if (cur != 0 && arr[cur - 1] >= i) continue;
            arr[cur] = i;
            isUsed[i] = true;
            func(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        arr = new int[7];
        isUsed = new boolean[25];
        board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        func(0);

        bw.write(ans + "\n");

        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}