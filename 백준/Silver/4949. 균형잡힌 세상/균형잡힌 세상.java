import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        while (!s.equals(".")) {
            boolean error = false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')') {
                    if (stack.empty()) {
                        error = true;
                        break;
                    } else if (stack.peek() != '(') {
                        error = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (c == ']') {
                    if (stack.empty()) {
                        error = true;
                        break;
                    } else if (stack.peek() != '[') {
                        error = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (c == '(') {
                    stack.push(c);
                }
                if (c == '[') {
                    stack.push(c);
                }
            }
            if (!stack.empty()) {
                error = true;
            }
            if (error) {
                bw.write("no\n");
            } else {
                bw.write("yes\n");
            }

            s = br.readLine();
        }

        br.close();
        bw.close();
    }
}