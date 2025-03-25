import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i * i <= n; i++) {
            while ((n % i) == 0) {
                sb.append(i + "\n");
                n /= i;
            }
        }
        if (n != 1) {
            sb.append(n);
        }

        bw.write(sb.toString());
        bw.close();
    }
}