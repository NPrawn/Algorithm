import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean error = false;
            Deque<Integer> dq = new LinkedList<>();
            int r = 1;
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (st.hasMoreTokens()) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < cmd.length(); i++) {
                if (cmd.charAt(i) == 'R') {
                    r = -r;
                } else {
                    if (dq.isEmpty()) {
                        bw.write("error\n");
                        error = true;
                        break;
                    } else if (r > 0) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
            if (!dq.isEmpty() && r > 0) {
                bw.write("[");
                while (!dq.isEmpty()) {
                    bw.write(Integer.toString(dq.pollFirst()));
                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            } else if (!dq.isEmpty() && r < 0) {
                bw.write("[");
                while (!dq.isEmpty()) {
                    bw.write(Integer.toString(dq.pollLast()));
                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            } else if(dq.isEmpty() && !error) {
                bw.write("[]\n");
            }
        }



        br.close();
        bw.close();
    }
}