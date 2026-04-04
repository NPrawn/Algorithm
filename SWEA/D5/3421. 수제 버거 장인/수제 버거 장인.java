import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] bad = new int[N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                bad[a] |= (1 << b);
                bad[b] |= (1 << a);
            }

            int size = 1 << N;
            boolean[] ok = new boolean[size];
            ok[0] = true;

            long ans = 1;

            for (int mask = 1; mask < size; mask++) {
                int last = mask & -mask;
                int i = Integer.numberOfTrailingZeros(last);
                int prev = mask ^ last;

                if (ok[prev] && (prev & bad[i]) == 0) {
                    ok[mask] = true;
                    ans++;
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
