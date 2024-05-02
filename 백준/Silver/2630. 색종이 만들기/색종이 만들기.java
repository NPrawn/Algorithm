import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] ans;
    static int[][] board;

    public static boolean check(int k, int a, int b) {
        for (int i = a; i < a + k; i++) {
            for (int j = b; j < b + k; j++) {
                if (board[a][b] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void func(int k, int a, int b) {
        if (check(k, a, b)) {
            ans[board[a][b]]++;
            return;
        }
        int n = k / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                func(n, a + i * n, b + j * n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        ans = new int[2];
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(n, 0, 0);

        for (int e : ans) {
            bw.write(e + "\n");
        }

        br.close();
        bw.close();
    }
}