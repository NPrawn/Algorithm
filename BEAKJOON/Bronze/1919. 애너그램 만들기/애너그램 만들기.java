import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        int[] arrA = new int[26];
        int[] arrB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            arrA[a.charAt(i) - 97]++;
        }
        for (int i = 0; i < b.length(); i++) {
            arrB[b.charAt(i) - 97]++;
        }
        int ct = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                ct += Math.max(arrA[i], arrB[i]) - Math.min(arrA[i], arrB[i]);
            }
        }

        bw.write(Integer.toString(ct));

        br.close();
        bw.close();
    }
}