import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = 10;
        while (T-- > 0) {
            int t = Integer.parseInt(input.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(input.readLine());
            for (int i = 0; i < 8; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            int idx=1;
            while (true) {
                int k = dq.pollFirst();
                k -= idx;
                if (k <= 0){
                    k = 0;
                    dq.addLast(k);
                    break;
                }
                dq.addLast(k);
                idx += 1;
                if (idx == 6) idx = 1;
            }

            sb.append("#").append(t).append(" ");
            for (int e : dq) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}