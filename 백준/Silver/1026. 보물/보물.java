import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stA.nextToken());
            b[i] = Integer.parseInt(stB.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += a[i] * b[n - i - 1];
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}