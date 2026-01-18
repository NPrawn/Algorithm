import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] broken = new int[n + 1]; // 1..n
        for (int i = 0; i < b; i++) {
            int x = Integer.parseInt(br.readLine());
            broken[x] = 1;
        }

        int[] ps = new int[n + 1]; // ps[i] = 1..i 누적
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + broken[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) { // 시작점 0..n-k
            int brokenCnt = ps[i + k] - ps[i];
            ans = Math.min(ans, brokenCnt);
        }

        System.out.println(ans);
    }
}
