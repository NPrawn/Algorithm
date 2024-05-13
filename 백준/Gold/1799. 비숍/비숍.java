import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, ans[];
    static ArrayList<Node> board[][];
    static boolean isUsed[][];


    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bishop(int idx, int cnt, int color) {
        if (idx == 2 * n) {
            ans[color] = Math.max(ans[color], cnt);
            return;
        }
        for (var v : board[color][idx]) {
            int x, y;
            x = v.x;
            y = v.y;
            if (isUsed[color][x + y]) continue;
            isUsed[color][x + y] = true;
            bishop(idx + 1, cnt + 1, color);
            isUsed[color][x + y] = false;
        }
        bishop(idx + 1, cnt, color);
    }

    public static void main(String[] args) throws IOException {
        n = toInt(br.readLine());
        board = new ArrayList[2][2 * n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2 * n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
        ans = new int[2];
        isUsed = new boolean[2][2 * n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    board[(i + j + 1) % 2][n - 1 - i + j].add(new Node(i, j));
                }
            }
        }

        bishop(0, 0, 0);
        bishop(0, 0, 1);

        bw.write((ans[0] + ans[1]) + "");
        bw.close();
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}