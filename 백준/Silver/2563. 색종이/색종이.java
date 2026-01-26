import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws Exception{
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[105][105];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i=a ; i<(Math.min(a+10, 100)); i++) {
                for (int j = b; j < (Math.min(b + 10, 100)); j++) {
                    map[i][j] = 1;
                }
            }

        }

        int ans = 0;
        for (int i = 0; i < 105; i++) {
            for (int j = 0; j < 105; j++) {
                ans += map[i][j];
            }
        }

        System.out.println(ans);
    }
}