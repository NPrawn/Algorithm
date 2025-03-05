import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] D;

    public static void main(String[] args) throws IOException {
        int X = Integer.parseInt(br.readLine());
        D = new int[X + 1];
        D[1] = 0;

        for (int i = 2; i <= X; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            if (i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }

        sb.append(D[X]);
        bw.write(sb.toString());
        bw.close();
    }

}