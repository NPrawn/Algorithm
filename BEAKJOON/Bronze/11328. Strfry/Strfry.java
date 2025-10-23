import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[26];
        int[] arrB = new int[26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arrA, 0);
            Arrays.fill(arrB, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            for (int j = 0; j < a.length(); j++) {
                arrA[a.charAt(j)-97]++;
            }
            for (int j = 0; j < b.length(); j++) {
                arrB[b.charAt(j)-97]++;
            }
            if (Arrays.equals(arrA, arrB)) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }
        }


        br.close();
        bw.close();
    }
}