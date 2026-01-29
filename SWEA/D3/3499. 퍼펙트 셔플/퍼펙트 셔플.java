import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(input.readLine());
            int k = n/2;
            if (n%2 == 1) k+=1;

            st = new StringTokenizer(input.readLine());
            Deque<String> arr1 = new ArrayDeque<>();
            Deque<String> arr2 = new ArrayDeque<>();

            for (int i = 0; i < k; i++)
                arr1.add(st.nextToken());
            for (int i = 0; i < n - k; i++) {
                arr2.add(st.nextToken());
            }

            sb.append("#").append(t).append(" ");
            while (!(arr1.isEmpty() && arr2.isEmpty())) {
                sb.append(arr1.pollFirst()).append(" ");
                if (arr2.isEmpty()) break;
                sb.append(arr2.pollFirst()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}