import java.io.*;
import java.util.*;

public class Main {
    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
                dist[i][j] = -1;
            }
        }

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        dist[0][0] = 0;
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (dist[nx][ny] != -1 || board[nx][ny] != 1) {
                    continue;
                }
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                que.add(new Pair(nx, ny));
            }
        }

        bw.write(Integer.toString(dist[n-1][m-1] + 1));

        br.close();
        bw.close();
    }
}