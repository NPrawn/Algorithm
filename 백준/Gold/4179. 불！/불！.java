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

        char[][] board = new char[n][m];
        int[][] distJ = new int[n][m];
        int[][] distF = new int[n][m];
        Queue<Pair> queJ = new LinkedList<>();
        Queue<Pair> queF = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
                distJ[i][j] = -1;
                distF[i][j] = -1;
                if (c == 'F') {
                    queF.add(new Pair(i, j));
                    distF[i][j] = 0;
                }
                if (c == 'J') {
                    queJ.add(new Pair(i, j));
                    distJ[i][j] = 0;
                }
            }
        }

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        while (!queF.isEmpty()) {
            Pair cur = queF.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == '#' || distF[nx][ny] >= 0) {
                    continue;
                }
                distF[nx][ny] = distF[cur.x][cur.y] + 1;
                queF.add(new Pair(nx, ny));
            }
        }

        while (!queJ.isEmpty()) {
            Pair cur = queJ.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    bw.write(Integer.toString(distJ[cur.x][cur.y] + 1));
                    bw.flush();
                    System.exit(0);
                }
                if (board[nx][ny] == '#' || distJ[nx][ny] >= 0) {
                    continue;
                }
                if (distJ[cur.x][cur.y] + 1 >= distF[nx][ny] && distF[nx][ny] >= 0) {
                    continue;
                }
                distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
                queJ.add(new Pair(nx, ny));
            }
        }
        bw.write("IMPOSSIBLE");

        br.close();
        bw.close();
    }
}