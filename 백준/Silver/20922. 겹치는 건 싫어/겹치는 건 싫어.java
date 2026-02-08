import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ct = new int[100000 + 5];
        int[] arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0; int r = 1;
        ct[arr[l]] += 1;
        int ans = 0;
        while (r < n) {
            ct[arr[r]] += 1;
            while (ct[arr[r]] > k) {
                ct[arr[l]] -= 1;
                l += 1;
            }

            ans = Math.max(ans, r-l);
            r += 1;
        }

        System.out.println(ans+1);
    }
}