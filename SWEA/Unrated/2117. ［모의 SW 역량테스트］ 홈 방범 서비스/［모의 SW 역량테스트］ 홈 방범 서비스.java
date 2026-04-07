import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader input =  new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashSet<Integer> set = new HashSet<>();

            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(input.readLine());
                for (int y = 0; y < n; y++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        set.add(getKey(x, y));
                    }
                }
            }

            int ans = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int k = 1; k <= 40; k++) {
                        int cost = k * k + (k - 1) * (k - 1);
                        int ct = 0;
                        for (int key : set) {
                            int nowX = key/100;
                            int nowY = key%100;
                            if (Math.abs(nowX - x) + Math.abs(nowY - y) <= k-1) {
                                ct+=1;
                            }
                        }

                        int profit = m*ct;
                        if (cost <= profit) {
                            ans = Math.max(ans, ct);
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int getKey(int x, int y) {
        return x*100 + y;
    }
}