import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i=0;i<n;i++)
                arr[i] = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int ct = n-i-1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] <= arr[j]) ct-=1;
                }
                ans = Math.max(ans, ct);
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb.toString());
    }
}