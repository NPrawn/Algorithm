import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean bool[] = new boolean[42];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            if (bool[a % 42]) {
                continue;
            }
            bool[a % 42] = true;
            ans++;
        }
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}