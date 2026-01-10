import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 앞에서부터 삭제하기 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[n + 1];
        int[] mins = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            mins[i] = Integer.MAX_VALUE;
        }

        for (int i = n-1; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + arr[i];
            mins[i] = Math.min(mins[i + 1], arr[i]);
        }

        double ans = Double.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int total = prefixSum[i] - mins[i];
            double avg = (double) total / (n - i - 1);
            ans = Math.max(ans, avg);
        }

        BigDecimal bd = BigDecimal.valueOf(ans).setScale(2, RoundingMode.HALF_UP);
        sb.append(bd.toPlainString());
        System.out.println(sb.toString());
    }
}