import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = Integer.MAX_VALUE;

        while (l < r) {
            int mid = 1 + l + (r - l) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
    }

    static boolean check(int x) {
        long ct = 0;
        for (int a : arr) {
            if (a > x) {
                ct += a - x;
            }
        }

        return  ct >= m;
    }
}
