import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX = 1000000;
    static boolean[] prime = new boolean[MAX + 5];

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            System.out.println("YES");
            return;
        }
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];

            if (a == 1 && b == 1) continue;
            if (a == 1 && prime[b]) continue;
            if (b == 1 && prime[a]) continue;

            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}