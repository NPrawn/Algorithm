import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> dq = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    int x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                case "push_back":
                    int y = Integer.parseInt(st.nextToken());
                    dq.addLast(y);
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(dq.pollFirst()) + "\n");
                    }
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(dq.pollLast()) + "\n");
                    }
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(dq.peekFirst()) + "\n");
                    }
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(dq.peekLast()) + "\n");
                    }
                    break;

            }
        }

        br.close();
        bw.close();
    }
}