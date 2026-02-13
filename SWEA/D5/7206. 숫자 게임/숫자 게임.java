import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int ans;

    static void dfs(String s, int ct) {
        int val = Integer.parseInt(s);
        if (val < 10) {
            ans = Math.max(ans, ct);
            return;
        }

        int n = s.length();
        int limit = 1 << (n - 1);

        for (int mask = 1; mask < limit; mask++) {
            long prod = 1;

            long cur = s.charAt(0) - '0';
            for (int i = 0; i < n - 1; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod *= cur;
                    cur = s.charAt(i + 1) - '0';
                } else {
                    cur = cur * 10 + (s.charAt(i + 1) - '0');
                }
            }
            prod *= cur;

            dfs(Long.toString(prod), ct + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            String s = input.readLine().trim();
            ans = 0;
            dfs(s, 0);
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
