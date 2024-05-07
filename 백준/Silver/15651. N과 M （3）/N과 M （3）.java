import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, arr[];

    public static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[cur] = i;
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = toInt(st.nextToken());
        m = toInt(st.nextToken());
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