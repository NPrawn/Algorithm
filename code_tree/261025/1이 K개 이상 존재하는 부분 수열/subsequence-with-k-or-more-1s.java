import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1 ? 1 : 0;
        }

        int left = 0;
        int right = 0;
        int sum = arr[0];
        while (left < n && arr[left] != 1) {
            left +=1;
        }
        right = left;
        sum = 1;
        int ans = Integer.MAX_VALUE;
        
        while (left < n && right < n) {
            if (sum < k) {
                right += 1;
                if (right == n) break;
                sum += arr[right];
            } else {
                ans = Math.min(ans, right - left + 1);
                left += 1;
                while(left < n && arr[left] != 1) {
                    left += 1;
                }
                if (left == n) break;
                sum -= arr[left];
            }
        }

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }
}