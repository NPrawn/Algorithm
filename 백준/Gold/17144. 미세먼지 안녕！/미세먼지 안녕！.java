import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int r, c, t, ans;
    static int[][] map;
    static ArrayList<Integer> cleaner = new ArrayList<>();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void clean() {
        int x = cleaner.get(0);
        int y = 0;
        for (int i = x; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 1; i < c; i++) {
            map[0][i - 1] = map[0][i];
        }
        for (int i = 1; i <= x; i++) {
            map[i - 1][c - 1] = map[i][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[x][i] = map[x][i - 1];
        }
        map[x][y] = -1;
        map[x][y + 1] = 0;
        x = cleaner.get(1);
        y = 0;
        for (int i = x + 1; i < r; i++) {
            map[i - 1][0] = map[i][0];
        }
        for (int i = 1; i < c; i++) {
            map[r - 1][i - 1] = map[r - 1][i];
        }
        for (int i = r - 1; i > x; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }
        for (int i = c - 1; i > 0; i--) {
            map[x][i] = map[x][i - 1];
        }
        map[x][y] = -1;
        map[x][y + 1] = 0;
    }

    static void spread() {
        int[][] Dust = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0; // 퍼트린 방 개수
                    int newDust = map[i][j] / 5; // 퍼트릴 먼지양
                    for (int idx = 0; idx < 4; idx++) {
                        int x = i + dx[idx];
                        int y = j + dy[idx];

                        if (x < 0 || x >= r || y < 0 || y >= c) {
                            continue;
                        }

                        if (map[x][y] == -1) {
                            continue;
                        }
                        Dust[x][y] += newDust;
                        cnt++;
                    }

                    map[i][j] -= newDust * cnt;
                }

            }
        }

        // 퍼트린 먼지 더하기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += Dust[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner.add(i);
                }
            }
        }

        for (int i = 0; i < t; i++) {
            spread();
            clean();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    ans += map[i][j];
                }
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