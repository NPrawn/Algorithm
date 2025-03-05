import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] s;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        s = new int[n + 2];
        d = new int[n + 2][3];
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        d[1][1] = s[1];
        d[1][2] = 0;
        d[2][1] = s[2];
        d[2][2] = s[1] + s[2];

        for (int i = 3; i <= n; i++) {
            d[i][1] = Math.max(d[i - 2][1], d[i - 2][2]) + s[i];
            d[i][2] = d[i - 1][1] + s[i];
        }

        sb.append(Math.max(d[n][1], d[n][2]));
        bw.write(sb.toString());
        bw.close();
    }
}