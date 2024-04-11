import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ct = 0;

        while (n-- > 0) {
            Stack<Character> stack = new Stack();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A') {
                    if (stack.empty()) {
                        stack.push(s.charAt(i));
                    } else if (stack.peek() == 'A') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
                if (s.charAt(i) == 'B') {
                    if (stack.empty()) {
                        stack.push(s.charAt(i));
                    } else if (stack.peek() == 'B') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            if (stack.empty()) {
                ct++;
            }
        }

        bw.write(Integer.toString(ct));

        br.close();
        bw.close();
    }
}