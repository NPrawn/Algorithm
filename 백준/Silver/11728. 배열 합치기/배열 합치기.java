import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < n; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        for (int i = 0; i < m; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;

        while (true) {
            if (a>=n && b>=m) break;
            if (a >= n) {
                sb.append(B[b++]);
            } else if (b >= m) {
                sb.append(A[a++]);
            } else if (A[a] < B[b]) {
                sb.append(A[a++]);
            } else {
                sb.append(B[b++]);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}