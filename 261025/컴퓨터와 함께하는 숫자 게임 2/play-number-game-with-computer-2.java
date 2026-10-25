import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long m, a, b;

    public static void main(String[] args) throws Exception {
        m = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int minAns = Integer.MAX_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for (long i=a; i<=b; i++) {
            int count = 0;
            
            long left = 1;
            long right = m;
            while (left <= right) {
                count += 1;
                long mid = (left+right) / 2;

                if (mid == i) {
                    break;
                } else if (mid < i) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            minAns = Math.min(minAns, count);
            maxAns = Math.max(maxAns, count);
        }

        System.out.println(minAns + " " + maxAns);
    }
}