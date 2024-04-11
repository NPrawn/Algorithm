import java.io.*;
import java.util.*;

public class Main {//(((()(()()))(())()))(()())
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ct = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                char next = s.charAt(i + 1);
                if (next == ')') {
                    ct += stack.size();
                    i++;
                } else {
                    stack.push(c);
                    ct++;
                }
            } else {
                stack.pop();
            }
        }
        bw.write(Integer.toString(ct));

        br.close();
        bw.close();
    }
}