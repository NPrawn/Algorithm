import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;
    static int n;
    static boolean[] isused1;
    static boolean[] isused2;
    static boolean[] isused3;

    public static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isused1[i]) continue;
            if (isused2[i + cur]) continue;
            if (isused3[i - cur + n - 1]) continue;
            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[i - cur + n - 1] = true;
            func(cur + 1);
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[i - cur + n - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        isused1 = new boolean[n];
        isused2 = new boolean[n * 2];
        isused3 = new boolean[n * 2];

        func(0);
        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}