import java.io.*;
import java.util.*;

public class Main {
    private static int t, n;
    private static int ct;
    private static int[] board;
    private static boolean[] vis, isGroup;

    public static void dfs(int idx) {
        if (isGroup[idx]) {
            return;
        }
        if (vis[idx]) {
            isGroup[idx] = true;
            ct++;
        }
        vis[idx] = true;
        dfs(board[idx]);
        isGroup[idx] = true;
        vis[idx] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            ct = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            board = new int[n + 1];
            isGroup = new boolean[n + 1];
            vis = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }

            bw.write(Integer.toString(n - ct) + "\n");
        }

        br.close();
        bw.close();

    }
}