import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            char[] arr = s.toCharArray();
            for (char e : arr) {
                if (e == '(') {
                    stack.push(e);
                } else {
                    if (stack.empty()) {
                        stack.push(e);
                        break;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(e);
                        break;
                    }
                }
            }
            if (stack.empty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        br.close();
        bw.close();
    }
}