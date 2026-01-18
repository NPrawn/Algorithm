import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, x, ans = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int l = 0;
        int r = n-1;
        while (l < r) {
            int a = arr[l];
            int b = arr[r];
            if (a + b == x) {
                ans++;
                l++;
                r--;
            } else if (a + b < x) {
                l+=1;
            } else {
                r-=1;
            }
        }

        sb.append(ans);
        System.out.println(sb.toString());
    }
}