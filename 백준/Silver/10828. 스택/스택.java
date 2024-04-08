import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(stack.pop()) + "\n");
                    }
                    break;
                case "size":
                    bw.write(Integer.toString(stack.size()) + "\n");
                    break;
                case "empty":
                    if (stack.empty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "top":
                    if (stack.empty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(Integer.toString(stack.peek()) + "\n");
                    }
                    break;
            }
        }

        br.close();
        bw.close();
    }
}