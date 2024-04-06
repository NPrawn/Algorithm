import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            leftStack.push(s.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":
                    if (!leftStack.empty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if (!rightStack.empty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "P":
                    String p = st.nextToken();
                    leftStack.push(p.charAt(0));
                    break;
                case "B":
                    if (!leftStack.empty()) {
                        leftStack.pop();
                    }
                    break;
            }
        }

        while (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.empty()) {
            bw.write(rightStack.pop());
        }


        br.close();
        bw.close();
    }
}