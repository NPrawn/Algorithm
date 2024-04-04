import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ct = 0;
        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][7];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(arr[i], 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[s][y]++;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                if (arr[i][j] % k == 0) {
                    ct += arr[i][j] / k;
                } else {
                    ct += arr[i][j] / k + 1;
                }
            }
        }
        bw.write(Integer.toString(ct));


        br.close();
        bw.close();
    }
}