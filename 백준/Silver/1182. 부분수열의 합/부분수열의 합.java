import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, s;
    static int[] arr;
    static int cnt = 0;

    public static void func(int cur, int total) {
        if (cur == n) {
            if (total == s) {
                cnt++;
            }
            return;
        }
        func(cur + 1, total);
        func(cur + 1, total + arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (s == 0) {
            cnt--;
        }
        bw.write(cnt + "\n");


        br.close();
        bw.close();
    }
}