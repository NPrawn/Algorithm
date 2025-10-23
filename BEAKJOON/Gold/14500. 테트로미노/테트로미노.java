import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = 0;
    static int[][] board;
    static boolean[][] vis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void run(int x, int y, int sum, int cur) {
        if (cur == 3) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (vis[nx][ny]) continue;
            if (cur == 1) {
                vis[nx][ny] = true;
                run(x, y, sum + board[nx][ny], cur + 1);
                vis[nx][ny] = false;
            }
            vis[nx][ny] = true;
            run(nx, ny, sum + board[nx][ny], cur + 1);
            vis[nx][ny] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = true;
                run(i, j, board[i][j], 0);
                vis[i][j] = false;
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}