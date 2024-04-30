import java.io.*;
import java.util.Stack;

public class Main {
    static int n;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        Stack<Integer> s = new Stack<>();
        int ct = 1;
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            while (ct <= t) {
                s.push(ct++);
                sb.append("+\n");
            }
            if (s.peek() != t) {
                bw.write("NO\n");
                bw.flush();
                System.exit(0);
            }
            s.pop();
            sb.append("-\n");
        }

        bw.write(sb.toString());



        br.close();
        bw.close();
    }
}