import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(input.readLine());
            Deque<Integer> dq1 = new ArrayDeque<>();
            Deque<Integer> dq2= new ArrayDeque<>();

            String s = st.nextToken();
            for (char c : s.toCharArray()) {
                dq1.addLast(c - '0');
            }
            s = st.nextToken();
            for (char c : s.toCharArray()) {
                dq2.addLast(c - '0');
            }

            while (dq1.size() < 105)
                dq1.addFirst(0);
            while (dq2.size() < 105)
                dq2.addFirst(0);

            int[] res = new int[105];
            for (int i = 0; i < 105; i++) {
                int a = dq1.pollFirst();
                int b = dq2.pollFirst();
                res[i] = a+b;
            }

            for (int i = 104; i >= 0; i--) {
                if (res[i] >= 10) {
                    res[i] -= 10;
                    res[i-1] += 1;
                }
            }

            sb.append("#").append(t).append(" ");
            boolean check = true;
            for (int i = 0; i < 105; i++) {
                if (res[i] != 0) check = false;
                if (check) continue;
                sb.append(res[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}