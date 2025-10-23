import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(s[n - i - 1] * (i + 1), ans);
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}