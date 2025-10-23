import java.io.*;
import java.util.*;

public class Main {
    static int n, m, arr[];
    static boolean isused[];

    public static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;
        if (cur != 0) st = arr[cur - 1] + 1;

        for (int i = st; i <= n; i++) {
            if (isused[i]) continue;
            arr[cur] = i;
            isused[i] = true;
            func(cur + 1);
            isused[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = toInt(st.nextToken());
        m = toInt(st.nextToken());
        isused = new boolean[n + 1];
        arr = new int[n + 1];

        func(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

}