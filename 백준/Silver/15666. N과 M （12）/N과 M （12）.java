import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, arr[], ans[];

    static void func(int cur) {
        if (cur == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (tmp == arr[i]) continue;
            if (cur != 0 && ans[cur - 1] > arr[i]) continue;
            ans[cur] = arr[i];
            tmp = ans[cur];
            func(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = toInt(st.nextToken());
        m = toInt(st.nextToken());
        arr = new int[n];
        ans = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = toInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0);
        bw.write(sb.toString());
        bw.close();
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}