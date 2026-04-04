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
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = arr[i] + arr[j];
                int l = 0;
                int r = n-1;

                while (l<r){
                    while (l == i || l == j) {
                        l += 1;
                    }
                    while (r == i || r == j) {
                        r -= 1;
                    }

                    if (l == n || r == -1 || l >= r) {
                        break;
                    }

                    int x = arr[l] + arr[r];
                    ans = Math.min(ans, Math.abs(k - x));
                    if (x < k) {
                        l += 1;
                    } else {
                        r -= 1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}