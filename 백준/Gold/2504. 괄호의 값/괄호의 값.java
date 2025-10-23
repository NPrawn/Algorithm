import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int val = 1;
        boolean error = false;

        for (int i = 0; i < s.length(); i++) {
            char e = s.charAt(i);
            if (e == '(') {
                val *= 2;
                stack.push(e);
            } else if (e == '[') {
                val *= 3;
                stack.push(e);
            } else if (e == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    error = true;
                    break;
                } else if (s.charAt(i - 1) == '(') {
                    result += val;
                }
                stack.pop();
                val /= 2;
            } else if (e == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    error = true;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    result += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (error || !stack.empty()) {
            bw.write("0");
        } else {
            bw.write(Integer.toString(result));
        }

        br.close();
        bw.close();
    }
}