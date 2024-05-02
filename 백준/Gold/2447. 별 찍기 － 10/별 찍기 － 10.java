import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static char[][] board;

    public static void space(int k, int a, int b) {
        for (int i = a; i < a + k; i++) {
            for (int j = b; j < b + k; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void star(int k, int a, int b) {
        if (k == 1) {
            board[a][b] = '*';
            return;
        }
        int n = k / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    space(n, a + i * n, b + j * n);
                } else {
                    star(n, a + i * n, b + j * n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        star(n, 0, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(board[i][j] + "");
            }
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}