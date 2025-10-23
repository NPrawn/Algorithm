import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] d, s;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        d = new int[n + 10];
        s = new int[n + 10];

        st = new StringTokenizer(br.readLine());
        s[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(s[b] - s[a - 1]);
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.close();
    }
}