import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static void rotate(int[] gear, int d) {
        if (d == 1) {
            int tmp = gear[7];
            for (int i = 7; i >= 1; i--) gear[i] = gear[i - 1];
            gear[0] = tmp;
        } else if (d == -1) {
            int tmp = gear[0];
            for (int i = 0; i <= 6; i++) gear[i] = gear[i + 1];
            gear[7] = tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            int k = Integer.parseInt(input.readLine());

            int[][] arr = new int[4][8];

            for (int g = 0; g < 4; g++) {
                st = new StringTokenizer(input.readLine());
                for (int i = 0; i < 8; i++) arr[g][i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(input.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());

                int[] dir = new int[4];
                dir[idx] = d;

                for (int j = idx - 1; j >= 0; j--) {
                    if (arr[j][2] != arr[j + 1][6]) dir[j] = -dir[j + 1];
                    else break;
                }

                for (int j = idx + 1; j < 4; j++) {
                    if (arr[j - 1][2] != arr[j][6]) dir[j] = -dir[j - 1];
                    else break;
                }

                // 회전 적용
                for (int g = 0; g < 4; g++) {
                    if (dir[g] != 0) rotate(arr[g], dir[g]);
                }
            }

            int ans = 0;
            for (int j = 0; j < 4; j++) {
                if (arr[j][0] == 1) ans += 1 << j;
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
