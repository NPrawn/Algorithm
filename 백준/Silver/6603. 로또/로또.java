import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[] ans = new int[6];
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n];
            used = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static void dfs(int d, int idx) {
        if (d == 6) {
            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append('\n');

            return;
        }

        for (int i = idx; i < n; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            ans[d] = arr[i];
            dfs(d + 1, i + 1);
            used[i] = false;
        }
    }
}
