import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write("*");
            }
            for (int j = 0; j < (n - i - 1) * 2; j++) {
                bw.write(" ");
            }
            for (int j = 0; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");

        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                bw.write("*");
            }
            for (int j = 0; j < (i + 1) * 2; j++) {
                bw.write(" ");
            }
            for (int j = i; j < n - 1; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}