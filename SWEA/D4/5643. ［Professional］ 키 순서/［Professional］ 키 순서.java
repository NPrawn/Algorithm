import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(input.readLine());
        for (int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(input.readLine());
            int m = Integer.parseInt(input.readLine());

            boolean[][] ck = new boolean[n+1][n+1];

            for (int t = 0; t < m; t++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ck[a][b] = true;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (ck[i][k] && ck[k][j]) ck[i][j] = true;
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                int cnt = 0;
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (ck[i][j] || ck[j][i]) cnt++;
                }
                if (cnt == n - 1) ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }

        System.out.println(sb.toString());
    }


}