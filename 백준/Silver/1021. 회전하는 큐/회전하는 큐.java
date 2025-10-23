import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }
        int[] list = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int ct = 0;
        int idx;
        int i = 0;
        while (i < m) {
            idx = 0;
            for (int e : dq) {
                if (e == list[i]) {
                    break;
                }
                idx++;
            }
            if (idx == 0) {
                dq.pollFirst();
                i++;
            } else if (idx <= dq.size() / 2) {
                dq.addLast(dq.pollFirst());
                ct++;
            } else {
                dq.addFirst(dq.pollLast());
                ct++;
            }
        }
        bw.write(Integer.toString(ct));

        br.close();
        bw.close();
    }
}