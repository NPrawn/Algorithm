import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, arr[];
    static boolean isUsed[];

    static void func(int cur) {
        if (cur == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) continue;
            arr[cur] = i;
            isUsed[i] = true;
            func(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isUsed = new boolean[n + 1];

        func(0);

        bw.write(sb.toString());

        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}