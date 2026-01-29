import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static long n;
    static int m;
    static int[] arr;

    static long served(long t) {
        long ct = m;
        for (int i = 0; i < m; i++) {
            ct += t / arr[i];
            if (ct >= n) return ct;
        }
        return ct;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        n = Long.parseLong(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        st = new StringTokenizer(input.readLine());
        int max = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        if (n <= m) {
            System.out.println(n);
            return;
        }

        long lo = 0;
        long hi = (long) max * n;

        if (hi < 0) hi = Long.MAX_VALUE / 2;

        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (served(mid) >= n) hi =mid;
            else lo = mid + 1;
        }

        long t = lo;

        long before = served(t - 1);
        long remain = n - before;

        for (int i = 0; i < m; i++) {
            if (t % arr[i] == 0) {
                remain--;
                if (remain == 0) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

    }
}