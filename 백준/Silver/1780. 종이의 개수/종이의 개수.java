import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] board;
    static int[] ans;

    public static void func(int k, int a, int b) {
        int p = board[a][b];
        if (k == 1) {
            ans[p + 1]++;
            return;
        }
        boolean e = false;
        for (int i = a; i < a + k; i++) {
            for (int j = b; j < b + k; j++) {
                if (board[i][j] != p) {
                    e = true;
                }
            }
        }
        if (e) {
            func(k / 3, a, b);
            func(k / 3, a + k / 3, b);
            func(k / 3, a + 2 * k / 3, b);
            func(k / 3, a, b + k / 3);
            func(k / 3, a + k / 3, b + k / 3);
            func(k / 3, a + 2 * k / 3, b + k / 3);
            func(k / 3, a, b + 2 * k / 3);
            func(k / 3, a + k / 3, b + 2 * k / 3);
            func(k / 3, a + 2 * k / 3, b + 2 * k / 3);
        } else {
            ans[p + 1]++;
        }

    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        ans = new int[3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(n, 1, 1);

        for (int i = 0; i < 3; i++) {
            bw.write(ans[i] + "\n");
        }

        br.close();
        bw.close();
    }
}