import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(input.readLine());
            int[][] points = new int[n][2];
            int sumX = 0;
            int sumY = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(input.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
                sumX += points[i][0];
                sumY += points[i][1];
            }

            long ans = Long.MAX_VALUE;

            int total = 1 << n;
            for (int mask = 0; mask < total; mask++) {
                if (Integer.bitCount(mask) != n/2) continue;
                ArrayList<Integer> pos = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) pos.add(i);
                }

                int px = 0;
                int py = 0;
                for (int idx : pos) {
                    px += points[idx][0];
                    py += points[idx][1];
                }

                long res = 0;
                res += (long) ((long) 2*px - sumX) * ((long) 2*px - sumX);
                res += (long) ((long) 2*py - sumY) * ((long) 2*py - sumY);

                ans = Math.min(res, ans);
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }
}