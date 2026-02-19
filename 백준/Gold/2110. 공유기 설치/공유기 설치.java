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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = Integer.MAX_VALUE;

        while (l < r) {
            int mid = l + 1 + (r - l) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
    }

    static boolean check(int x) {
        int t = m-2;
        int now = arr[0];
        while (t-- > 0) {
            int idx = upper(now + x);
            if (idx >= n) {
                return false;
            }
            now = arr[upper(now + x)];
        }

        return arr[n - 1] - now >= x;
    }

    static int upper(int x) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
