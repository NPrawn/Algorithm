import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int ans[];
    static int n;
    static boolean isUsed[];

    static void func(int cur) {
        if (cur == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;
            if (cur != 0 && ans[cur - 1] > arr[i]) continue;
            isUsed[i] = true;
            ans[cur] = arr[i];
            func(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr = new int[n];
            ans = new int[6];
            isUsed = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            func(0);

            sb.append("\n");
            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}