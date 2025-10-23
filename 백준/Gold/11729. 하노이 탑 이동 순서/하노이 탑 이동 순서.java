import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void Hanoi(int a, int b, int k) throws IOException {
        if (k == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        Hanoi(a, 6 - a - b, k - 1);
        bw.write(a + " " + b + "\n");

        Hanoi(6 - a - b, b, k - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        bw.write((1 << k) - 1 + "\n");
        Hanoi(1, 3, k);

        bw.close();
        br.close();
    }
}