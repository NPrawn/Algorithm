import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        while (true) {
            String s = input.readLine();
            boolean check = true;
            if (s.equals(".")) break;
            ArrayDeque<Character> dq = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    dq.offerLast(c);
                } else if (c == '[')
                    dq.offerLast(c);
                else if ( c == ')') {
                    if (!dq.isEmpty() && dq.peekLast() == '(')
                        dq.pollLast();
                    else {
                        check = false;
                        break;
                    }
                } else if (c == ']') {
                    if (!dq.isEmpty() && dq.peekLast() == '[')
                        dq.pollLast();
                    else {
                        check = false;
                        break;
                    }
                }
            }
            if (!dq.isEmpty()) check = false;
            sb.append(check ? "yes" : "no").append("\n");
        }

        System.out.println(sb.toString());
    }
}