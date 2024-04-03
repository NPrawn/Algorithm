import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int[] arr = new int[10];
        String n = br.readLine();
        for (int i = 0; i < n.length(); i++) {
            arr[n.charAt(i) - '0']++;
        }
        arr[6] += arr[9];
        arr[9] = 0;
        if (arr[6] % 2 == 0) {
            arr[6] /= 2;
        } else {
            arr[6] /= 2;
            arr[6]++;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}