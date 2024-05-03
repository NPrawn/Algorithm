import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static char[][] board;


    public static void func(int n, int a, int b) {
        if (n == 3) {
            for (int i = a; i < a + 3; i++) {
                for (int j = b - 2; j < b + 3; j++) {
                    if (i == a && j != b) {
                        board[i][j] = ' ';
                        continue;
                    }
                    if (i == a + 1 && !(j == b - 1 || j == b + 1)) {
                        board[i][j] = ' ';
                        continue;
                    }
                    board[i][j] = '*';
                }
            }
            return;
        }
        int k = n / 2;
        func(k, a, b);
        func(k, a + k, b - k);
        func(k, a + k, b + k);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = n * 2 - 1;
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ' ');
        }
        func(n, 0, n - 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(board[i][j] + "");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}