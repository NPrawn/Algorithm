import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, q;
    static int[] arr;
    static int[] leftMax;
    static int[] rightMax;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n];
        leftMax = new int[n+2];
        rightMax = new int[n+2];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
        }

        for (int i=n; i>0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i-1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(Math.max(leftMax[a-1], rightMax[b+1]));
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }
}