import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] board;

    public static boolean check(int n, int a, int b) {
        for (int i = a; i < a + n; i++) {
            for (int j = b; j < b + n; j++) {
                if (board[a][b] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void func(int k,int a,int  b) throws IOException {
        if (check(k, a, b)) {
            bw.write(Integer.toString(board[a][b]));
            return;
        }
        bw.write("(");
        int n = k / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                func(n, a + i * n, b + j * n);
            }
        }
        bw.write(")");
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        func(n, 0, 0);


        br.close();
        bw.close();
    }
}