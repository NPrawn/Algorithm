import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int[] arr = new int[10];
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String s = Integer.toString(a * b * c);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 48]++;
        }

        for (int e : arr) {
            bw.write(e + "\n");
        }

        br.close();
        bw.close();
    }
}