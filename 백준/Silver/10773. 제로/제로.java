import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }
        int sum = 0;
        for (int e : stack) {
            sum += e;
        }

        bw.write(Integer.toString(sum));

        br.close();
        bw.close();
    }
}