import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, arr[], cal[], max, min, k, oper[];

    static void solve(int cur) {
        if (cur == k) {
            int tmp = arr[0];
            for (int i = 1; i < n; i++) {
                if (oper[i - 1] == 0) {
                    tmp += arr[i];
                } else if (oper[i - 1] == 1) {
                    tmp -= arr[i];
                } else if (oper[i - 1] == 2) {
                    tmp *= arr[i];
                } else {
                    tmp /= arr[i];
                }
            }
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] == 0) continue;
            cal[i]--;
            oper[cur] = i;
            solve(cur + 1);
            cal[i]++;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = n - 1;
        arr = new int[n];
        cal = new int[4];
        oper = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        max = -1000000000;
        min = 1000000000;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);


        bw.write(max + "\n" + min);
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}