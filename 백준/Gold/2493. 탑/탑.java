import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Stack<Node> stack = new Stack<>();

    public static class Node {
        int idx;
        int h;

        Node(int h, int idx) {
            this.h = h;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        stack.push(new Node(100000001, 0));
        for (int i = 1; i <= n; i++) {
            int height;
            height = Integer.parseInt(st.nextToken());
            while (stack.peek().h < height) {
                stack.pop();
            }
            bw.write(stack.peek().idx + " ");
            stack.push(new Node(height, i));
        }

        br.close();
        bw.close();
    }
}