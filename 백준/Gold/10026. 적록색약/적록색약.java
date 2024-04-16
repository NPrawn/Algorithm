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

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }
        int m = s[0].length();

        Queue<Pair> queN = new LinkedList<>();
        Queue<Pair> queB = new LinkedList<>();
        char[][] boardN = new char[n][m];
        char[][] boardB = new char[n][m];
        boolean[][] visN = new boolean[n][m];
        boolean[][] visB = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ctN = 0;
        int ctB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boardN[i][j] = s[i].charAt(j);
                boardB[i][j] = s[i].charAt(j);
                if (s[i].charAt(j) == 'G') {
                    boardB[i][j] = 'R';
                }
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = boardN[i][j];
                char b = boardB[i][j];
                if (!visN[i][j]) {
                    queN.add(new Pair(i, j));
                    visN[i][j] = true;
                    ctN++;
                    while (!queN.isEmpty()) {
                        Pair cur = queN.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (visN[nx][ny] || c != boardN[nx][ny]) {
                                continue;
                            }
                            queN.add(new Pair(nx, ny));
                            visN[nx][ny] = true;
                        }
                    }
                }
                if (!visB[i][j]) {
                    queB.add(new Pair(i,j));
                    visB[i][j] = true;
                    ctB++;
                    while (!queB.isEmpty()) {
                        Pair cur = queB.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }
                            if (b != boardB[nx][ny] || visB[nx][ny]) {
                                continue;
                            }
                            queB.add(new Pair(nx, ny));
                            visB[nx][ny] = true;
                        }
                    }
                }
            }
        }


        bw.write(Integer.toString(ctN) + " " + Integer.toString(ctB));

        br.close();
        bw.close();
    }
}