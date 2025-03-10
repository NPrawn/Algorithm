import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] dp, pre;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 10];
        pre = new int[n + 10];
        dp[1] = 0;
        pre[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
        }
        sb.append(dp[n] + "\n");
        while (true) {
            if (n == 0) {
                break;
            }
            sb.append(n + " ");
            n = pre[n];
        }

        bw.write(sb.toString());
        bw.close();
    }
}