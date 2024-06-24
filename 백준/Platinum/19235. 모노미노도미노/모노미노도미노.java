import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] blue = new int[6][4];
    static int[][] green = new int[6][4];
    static int score;

    static void dropblock(int t, int x, int y, boolean isBlue) {
        int[][] map;
        if (isBlue) {
            map = blue;
            x = y ^ x ^ (y = x);
            t = t == 1 ? 1 : t == 2 ? 3 : 2;
        } else {
            map = green;
        }

        int row = 0;
        for (int i = 2; i <= 6; i++) {
            if (i == 6) {
                row = i - 1;
                break;
            }
            if (map[i][y] != 0) {
                row = i - 1;
                break;
            }
            if (t == 2 && map[i][y + 1] != 0) {
                row = i - 1;
                break;
            }
        }
        map[row][y] = 1;
        if (t == 2) {
            map[row][y] = 2;
            map[row][y + 1] = 3;
        } else if (t == 3) {
            map[row - 1][y] = 1;
        }
    }

    static void dropblank(int t, int x, int y, boolean isBlue) {
        int[][] map = isBlue ? blue : green;
        int row = 0;
        for (int i = x + 1; i <= 6; i++) {
            if (i == 6) {
                row = i - 1;
                break;
            }
            if (map[i][y] != 0) {
                row = i - 1;
                break;
            }
            if (t == 2 && map[i][y + 1] != 0) {
                row = i - 1;
                break;
            }
        }
        map[row][y] = 1;
        if (t == 2) {
            map[row][y] = 2;
            map[row][y + 1] = 3;
        }
    }

    static void fill(boolean isBlue) {
        int[][] map = isBlue ? blue : green;
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 0) {
                    map[i][j] = 0;
                    dropblank(1, i, j, isBlue);
                }
                if (map[i][j] == 2 && map[i + 1][j + 1] == 0 && map[i + 1][j] == 0) {
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                    dropblank(2, i, j, isBlue);
                }
            }
        }
    }

    static boolean oneline(boolean isBlue) {
        int[][] map = isBlue ? blue : green;
        boolean pung = false;
        for (int i = 2; i < 6; i++) {
            boolean fill = true;
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 0) {
                    fill = false;
                    break;
                }
            }
            if (fill) {
                score++;
                for (int j = 0; j < 4; j++) {
                    map[i][j] = 0;
                }
                pung = true;
            }
        }
        return pung;
    }

    static void special(boolean isBlue) {
        int[][] map = isBlue ? blue : green;
        int dline = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    dline++;
                    break;
                }
            }
        }
        for (int i = 5; i > 5 - dline; i--) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = 0;
            }
        }
    }

    static int count(boolean isBlue) {
        int[][] map = isBlue ? blue : green;
        int ct = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3) {
                    ct++;
                }
            }
        }
        return ct;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean isBlue = true;
            for (int k = 0; k < 2; k++) {
                dropblock(t, x, y, isBlue);
                boolean pung = true;
                while (pung) {
                    pung = oneline(isBlue);
                    fill(isBlue);
                }
                special(isBlue);
                fill(isBlue);
                isBlue = false;
            }
        }
        int cnt = count(true) + count(false);
        sb.append(score + "\n" + cnt);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}