import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int x = -1;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(queue.poll()) + "\n");
                    }
                    break;
                case "size":
                    bw.write(Integer.toString(queue.size()) + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(queue.peek()) + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(x) + "\n");
                    }
                    break;
            }
        }

        br.close();
        bw.close();
    }
}