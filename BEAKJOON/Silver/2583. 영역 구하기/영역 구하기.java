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

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];


        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p1x = Integer.parseInt(st.nextToken());
            int p1y = Integer.parseInt(st.nextToken());
            int p2x = Integer.parseInt(st.nextToken());
            int p2y = Integer.parseInt(st.nextToken());

            for (int i = p1x; i < p2x; i++) {
                for (int j = p1y; j < p2y; j++) {
                    board[i][j] = -1;
                }
            }
        }

        Queue<Pair> que = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<Integer> area = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !vis[i][j]) {
                    int are = 1;
                    que.add(new Pair(i, j));
                    vis[i][j] = true;

                    while (!que.isEmpty()) {
                        Pair cur = que.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if (board[nx][ny] == -1 || vis[nx][ny]) continue;
                            que.add(new Pair(nx, ny));
                            vis[nx][ny] = true;
                            are++;
                        }
                    }
                    area.add(are);
                }
            }
        }

        bw.write(Integer.toString(area.size()));
        bw.write("\n");
        Collections.sort(area);

        for (int e : area) {
            bw.write(Integer.toString(e) + " ");
        }

        br.close();
        bw.close();
    }
}