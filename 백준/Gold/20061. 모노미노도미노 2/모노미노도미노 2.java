import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] map = new int[10][10];

    static void block(int t, int x, int y) {
        if (t == 1) {
            int j = 0;
            for (j = 4; j <= 9; j++) {
                if (map[x][j] == 0) continue;
                break;
            }
            map[x][j - 1] = 1;
            int i = 0;
            for (i = 4; i <= 9; i++) {
                if (map[i][y] == 0) continue;
                break;
            }
            map[i - 1][y] = 1;
        } else if (t == 2) {
            int j = 0;
            for (j = 5; j <= 9; j++) {
                if (map[x][j] == 0 && map[x][j - 1] == 0) continue;
                break;
            }
            map[x][j - 1] = 1;
            map[x][j - 2] = 1;
            int i = 0;
            for (i = 4; i <= 9; i++) {
                if (map[i][y] == 0 && map[i][y + 1] == 0) continue;
                break;
            }
            map[i - 1][y] = 1;
            map[i - 1][y + 1] = 1;
        } else if (t == 3) {
            int j = 0;
            for (j = 4; j <= 9; j++) {
                if (map[x][j] == 0 && map[x + 1][j] == 0) continue;
                break;
            }
            map[x][j - 1] = 1;
            map[x + 1][j - 1] = 1;
            int i = 0;
            for (i = 5; i <= 9; i++) {
                if (map[i][y] == 0 && map[i - 1][y] == 0) continue;
                break;
            }
            map[i - 1][y] = 1;
            map[i - 2][y] = 1;
        }
        score();
    }

    static void score() {
        f:
        for (int j = 6; j <= 9; j++) {
            for (int i = 0; i < 4; i++) {
                if (map[i][j] == 0) continue f;
            }
            ans++;
            for (int k = j; k >= 5; k--) {
                for (int i = 0; i < 4; i++) {
                    map[i][k] = map[i][k - 1];
                }
            }
            for (int i = 0; i < 4; i++) {
                map[i][4] = 0;
            }
        }
        f:
        for (int i = 6; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 0) continue f;
            }
            ans++;
            for (int k = i; k >= 5; k--) {
                map[k] = map[k - 1];
            }
            map[4] = new int[10];
        }

        f:
        for (int j = 4; j <= 5; j++) {
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                if (map[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int k = 9; k > j; k--) {
                    for (int i = 0; i < 4; i++) {
                        map[i][k] = map[i][k - 1];
                    }
                }
                for (int i = 0; i < 4; i++) {
                    map[i][j] = 0;
                }
            }
        }

        f:
        for (int i = 4; i <= 5; i++) {
            boolean flag = false;
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int k = 9; k > i; k--) {
                    map[k] = map[k - 1];
                }
                map[i] = new int[10];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            block(t, x, y);
        }
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) cnt++;
            }
        }
        sb.append(ans + "\n" + cnt);
        bw.write(sb.toString());
        bw.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}