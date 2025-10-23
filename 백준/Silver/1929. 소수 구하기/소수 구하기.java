import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int m, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        boolean[] state = new boolean[n + 1];
        Arrays.fill(state, true);
        state[1] = false;

        for (int i = 2; i <= n; i++) {
            if (!state[i]) continue;
            for (int j = 2 * i; j <= n; j += i) {
                state[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (state[i]) {
                sb.append(i + "\n");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}