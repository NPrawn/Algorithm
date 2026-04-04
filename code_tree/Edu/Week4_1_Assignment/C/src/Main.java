import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        // 중앙값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        while (T-- > 0) {
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (left.isEmpty() || x <= left.peek()) {
                    left.offer(x);
                } else {
                    right.offer(x);
                }

                if (left.size() < right.size()) {
                    left.offer(right.poll());
                } else if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                }

                if (i % 2 == 0) {
                    sb.append(left.peek()).append(' ');
                }
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}