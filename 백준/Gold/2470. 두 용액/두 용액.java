import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l=0;
        int r = n - 1;
        int[] ans = new int[2];
        int min = Integer.MAX_VALUE;

        while (l < r) {
            int res = arr[l] + arr[r];
            if (Math.abs(res) < min) {
                min = Math.abs(res);
                ans[0] = arr[l];
                ans[1] = arr[r];
            }

            if (res < 0) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}