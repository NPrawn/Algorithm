package A.정수_명령_처리_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int k = Integer.parseInt(st.nextToken());
                pq.add(-k);
            } else if (cmd.equals("pop")) {
                sb.append(-pq.poll()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(pq.size()).append('\n');
            } else if (cmd.equals("empty")) {
                if (pq.isEmpty())
                    sb.append("1\n");
                else {
                    sb.append("0\n");
                }
            } else if (cmd.equals("top")) {
                sb.append(-pq.peek()).append('\n');
            }
        }

        System.out.println(sb.toString());

    }
}
