import java.awt.desktop.AboutEvent;
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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] board = new char[n][m];
            int[][] distS = new int[n][m];
            int[][] distF = new int[n][m];
            Queue<Pair> queF = new LinkedList<>();
            Queue<Pair> queS = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    board[i][j] = s.charAt(j);
                    distF[i][j] = -1;
                    distS[i][j] = -1;
                    if (board[i][j] == '@') {
                        queS.add(new Pair(i, j));
                        distS[i][j] = 0;
                    }
                    if (board[i][j] == '*') {
                        queF.add(new Pair(i, j));
                        distF[i][j] = 0;
                    }
                }
            }
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            while (!queF.isEmpty()) {
                Pair cur = queF.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if (distF[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                    queF.add(new Pair(nx, ny));
                    distF[nx][ny] = distF[cur.x][cur.y] + 1;
                }
            }
            boolean error = true;
            while (!queS.isEmpty()) {
                Pair cur = queS.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        bw.write(Integer.toString(distS[cur.x][cur.y] + 1) + "\n");
                        queS.clear();
                        error = false;
                        break;
                    }
                    if (distS[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                    if (distS[cur.x][cur.y] + 1 >= distF[nx][ny] && distF[nx][ny] >= 0) continue;
                    queS.add(new Pair(nx, ny));
                    distS[nx][ny] = distS[cur.x][cur.y] + 1;
                }
            }

            if (error) {
                bw.write("IMPOSSIBLE\n");
            }
        }

        br.close();
        bw.close();
    }
}