import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] r, g, b;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        r = new int[n + 1];
        g = new int[n + 1];
        b = new int[n + 1];
        d = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        d[1][0] = r[0];
        d[1][1] = g[0];
        d[1][2] = b[0];
        for (int i = 1; i <= n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + r[i];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + g[i];
            d[i][2] = Math.min(d[i - 1][1], d[i - 1][0]) + b[i];
        }

        sb.append(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));
        bw.write(sb.toString());
        bw.close();
    }
}