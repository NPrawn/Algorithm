import java.io.*;
import java.util.Stack;

public class Main {
    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Node> s = new Stack<>();
        long ans = 0;
        while (n-- > 0) {
            int h = Integer.parseInt(br.readLine());
            int cnt = 1;
            while (!s.empty() && s.peek().x <= h) {
                ans += s.peek().y;
                if (s.peek().x == h) cnt += s.peek().y;
                s.pop();
            }
            if (!s.empty()) ans++;
            s.push(new Node(h, cnt));
        }


        bw.write(ans + "\n");
        br.close();
        bw.close();
    }
}