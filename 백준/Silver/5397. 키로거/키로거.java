import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '<':
                        if (!leftStack.empty()) {
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case '>':
                        if (!rightStack.empty()) {
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    case '-':
                        if (!leftStack.empty()) {
                            leftStack.pop();
                        }
                        break;
                    default:
                        leftStack.push(c);
                        break;
                }
            }
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
            while (!rightStack.empty()) {
                bw.write(rightStack.pop());
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}