import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(input.readLine());

        for (int t =1; t<=n; t++){
            Deque<String> dq = new ArrayDeque<>();
            st = new StringTokenizer(input.readLine());
            while (st.hasMoreTokens()) {
                dq.offerLast(st.nextToken());
            }

            sb.append("Case #").append(t).append(": ");
            while (!dq.isEmpty()) {
                sb.append(dq.pollLast());
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}