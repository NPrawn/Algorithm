import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, arr[];
    static boolean player[];
    static boolean dealer[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        player = new boolean[n + 1];
        dealer = new boolean[n + 1];
        Arrays.fill(player, true);
        Arrays.fill(dealer, true);
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int e = Integer.parseInt(st.nextToken());
            max = Math.max(max, e);
            min = Math.min(min, e);
            arr[i] = e;
        }

        while (m-- > 0) {
            boolean canP = false;
            boolean canD = false;
            for (int i = 0; i <= n; i++) {
                if (dealer[i]) canD = true;
                if (player[i]) canP = true;
            }
            if (!canP && !canD) break;
            for (int i = 1; i < arr.length; i++) {
                if (max < 0) {
                    dealer[0] = false;
                    player[0] = false;
                    break;
                }
                if (arr[i] == max) {
                    dealer[i] = false;
                    player[i] = false;
                    ans += arr[i];
                    arr[i] = 2000;
                    max = Integer.MIN_VALUE;
                    break;
                }
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == min) {
                    dealer[i] = false;
                    player[i] = false;
                    arr[i] = 2000;
                    min = Integer.MAX_VALUE;
                    break;
                }
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 2000) continue;
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }
        }

        bw.write(ans + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}