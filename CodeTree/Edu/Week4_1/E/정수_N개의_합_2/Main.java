package E.정수_N개의_합_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long n, m, k;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        arr = new long[(int) n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (int) n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long[] prefixSum = new long[(int) n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }
        long ans = Long.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            ans = Math.max((prefixSum[i + (int) k] - prefixSum[i]), ans);
        }
        sb.append(ans);
        System.out.println(sb.toString());
    }
}
