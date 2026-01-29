import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] a = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];

    static int[] er = new int[81];
    static int[] ec = new int[81];
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            String s = input.readLine();
            for (int j = 0; j < 9; j++) {
                int v = s.charAt(j) - '0';
                a[i][j] = v;
                if (v == 0) {
                    er[cnt] = i;
                    ec[cnt] = j;
                    cnt++;
                } else {
                    row[i][v] = true;
                    col[j][v] = true;
                    box[bi(i,j)][v] = true;
                }
            }
        }

        dfs(0);

    }

    static int bi(int r, int c) {
        return (r/3) * 3 + (c / 3);
    }

    static void dfs(int idx) throws Exception {
        if (idx == cnt) {
            for (int i = 0; i < 9; i++) {
                for (int j =0; j< 9; j++) sb.append(a[i][j]);
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        int r = er[idx];
        int c = ec[idx];
        int b = bi(r,c);

        for (int v = 1; v <= 9; v++) {
            if (row[r][v] || col[c][v] || box[b][v]) continue;

            a[r][c] = v;
            row[r][v] = col[c][v] = box[b][v] = true;

            dfs(idx+1);
            a[r][c] = 0;
            row[r][v] = col[c][v] = box[b][v] = false;
        }
    }
}