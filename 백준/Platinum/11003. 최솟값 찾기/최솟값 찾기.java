import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Deque<int[]> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekLast()[0] > val) {
                dq.pollLast();
            }
            dq.addLast(new int[]{val, i});
            if (dq.peekFirst()[1] < i - l + 1) {
                dq.pollFirst();
            }

            bw.write(dq.peekFirst()[0] + " ");
        }

        br.close();
        bw.close();
    }
}