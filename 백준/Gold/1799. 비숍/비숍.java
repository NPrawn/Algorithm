import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, board[][], k, arr[][], ans = 0, ct;
    static boolean isUsed[];

    static void func(int cur) {
        if (cur == k) {
            ans = Math.max(ans, ct);
            return;
        }
        if (cur == 0) ct = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            int x, y;
            if (cur >= n) {
                x = n - 1 - i;
                y = cur - x;
            }else
            {
                y = i;
                x = cur - y;
            }
            if (arr[cur][i] == 0) {
                tmp++;
                continue;
            }
            if (isUsed[n - 1 - x + y]) {
                tmp++;
                continue;
            }
            ct++;
            isUsed[n - 1 - x + y] = true;
            func(cur + 1);
            isUsed[n - 1 - x + y] = false;
            ct--;
        }
        if (tmp == n) {
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = 2 * n - 1;
        board = new int[n][n];
        isUsed = new boolean[k];
        arr = new int[k][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (i + j >= n) {
                    arr[i + j][n - 1 - i] = board[i][j];
                } else {
                    arr[i + j][j] = board[i][j];
                }
            }
        }

        func(0);


        bw.write(ans + "");
        br.close();
        bw.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}