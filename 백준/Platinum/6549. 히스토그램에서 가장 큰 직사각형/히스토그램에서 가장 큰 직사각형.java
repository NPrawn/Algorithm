import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        long x;
        long y;

        Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            Stack<Node> s = new Stack<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                long h = Integer.parseInt(st.nextToken());
                long idx = i;
                while (!s.empty() && s.peek().x >= h) {
                    ans = Math.max(ans, (i - s.peek().y) * s.peek().x);
                    idx = s.peek().y;
                    s.pop();
                }
                s.push(new Node(h, idx));
            }
            while (!s.empty()) {
                ans = Math.max(ans, (n - s.peek().y) * s.peek().x);
                s.pop();
            }

            bw.write(ans + "\n");
        }

        br.close();
        bw.close();
    }
}