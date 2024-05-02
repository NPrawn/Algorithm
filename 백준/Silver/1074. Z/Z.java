import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, r, c;


    public static int Z(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }
        int half = 1 << (n - 1);
        if (r < half && c < half) {
            return Z(n - 1, r, c);
        }
        if (r < half && c >= half) {
            return half * half + Z(n - 1, r, c - half);
        }
        if (r >= half && c < half) {
            return 2 * half * half + Z(n - 1, r - half, c);
        }
        return 3 * half * half + Z(n - 1, r - half, c - half);
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(Z(n, r, c) + "\n");

        br.close();
        bw.close();
    }
}