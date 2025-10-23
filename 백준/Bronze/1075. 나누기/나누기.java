import java.io.*;

public class Main {
    static int n, f, ans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        f = Integer.parseInt(br.readLine());

        n /= 100;
        n *= 100;

        for (int i = 0; i < 101; i++) {
            ans = n + i;
            if (ans % f == 0) {
                break;
            }
        }

        ans %= 100;


        System.out.println(String.format("%02d", ans));
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}