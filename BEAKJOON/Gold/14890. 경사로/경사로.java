import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, l, ans = 0;
    static int[][] map;

    static boolean row(int row) {
        boolean[] isUsed = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];
            if (diff > 1) return false;
            else if (diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isUsed[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    isUsed[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isUsed[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    isUsed[i + j] = true;
                }
            }
        }
        return true;
    }

    static boolean col(int col) {
        boolean[] isUsed = new boolean[n];
        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || isUsed[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    isUsed[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || isUsed[i + j]) return false;
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    isUsed[i + j] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (row(i)) ans++;
            if (col(i)) ans++;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}