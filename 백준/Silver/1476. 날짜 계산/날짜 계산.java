import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken()) - 1;
        int s = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(st.nextToken()) - 1;

        int ans = 1;
        while (ans++ >= 0) {
            if (ans % 15 == e && ans % 28 == s && ans % 19 == m) {
                break;
            }
        }
        ans += 1;
        if (ans > 7980) {
            ans %= 7980;
        }
        System.out.println(ans);
    }
}