import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] d;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        d = new int[12];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            for (int j = 4; j <= x; j++) {
                d[j] = d[j - 1] + d[j - 2] + d[j - 3];
            }
            sb.append(d[x] + "\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

}