import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long pow(long a, long b, long c) {
        if (b == 1) return a % c;
        long val = pow(a, b / 2, c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        bw.write(pow(a, b, c) + "\n");


        br.close();
        bw.close();
    }

}