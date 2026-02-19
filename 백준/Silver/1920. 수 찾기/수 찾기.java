import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());

        int[] xs = new int[m];
        for (int i = 0; i < m; i++) {
            xs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int x : xs) {
            int l = 0;
            int r = n;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l < n && arr[l] == x) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
