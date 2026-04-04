import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 마지막으로 남은 숫자
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a == b) {
                continue;
            }
            pq.offer(Math.abs(a - b));
        }

        if (pq.isEmpty()) {
            sb.append("-1");
        } else {
            sb.append(pq.poll());
        }
        System.out.println(sb.toString());
    }
}