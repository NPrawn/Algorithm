import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    static void dfs(int depth, int cur) {
        if (cur == n-1) {
            ans = Math.min(ans, depth);
        }

        for (int i=cur+1; i <= cur+arr[cur]; i++) {
            if (i >= n) break;
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
}