import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ct = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == x) {
                left++;
                right--;
                ct++;
            } else if (sum > x) {
                right--;
            } else {
                left++;
            }
        }
        bw.write(Integer.toString(ct));

        br.close();
        bw.close();
    }
}