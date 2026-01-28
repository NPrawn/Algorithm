import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            char[] arr = br.readLine().toCharArray();
            int ans = 0;
            char now = '0';
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != now) {
                    ans += 1;
                    now = arr[i];
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}