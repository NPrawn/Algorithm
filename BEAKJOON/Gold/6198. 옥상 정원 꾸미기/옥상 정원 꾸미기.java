import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Long> s = new Stack<>();
        long ct = 0;
        long n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long h = Long.parseLong(br.readLine());
            while (!s.isEmpty() && s.peek() <= h) {
                s.pop();
            }
            ct += s.size();
            s.push(h);
        }

        bw.write(ct + "\n");

        br.close();
        bw.close();
    }
}