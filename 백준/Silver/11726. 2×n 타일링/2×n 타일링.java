import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] d;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 100];
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] = d[i] % 10007;
        }
        sb.append(d[n]);
        bw.write(sb.toString());
        bw.close();
    }
}