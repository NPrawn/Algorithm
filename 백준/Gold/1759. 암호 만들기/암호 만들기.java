import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l, c;
    static char[] arr, ans;
    static boolean[] isUsed;

    static void func(int cur) {
        if (cur == l) {
            int ct = 0;
            int tc = 0;
            for (int i = 0; i < l; i++) {
                switch (ans[i]) {
                    case 'a': ct++;
                        break;
                    case 'e': ct++;
                        break;
                    case 'i': ct++;
                        break;
                    case 'o': ct++;
                        break;
                    case 'u': ct++;
                        break;
                    default: tc++;
                        break;
                }
            }
            if (ct == 0 || tc < 2) {
                return;
            }
            for (int i = 0; i < l; i++) {
                sb.append(ans[i]);
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < c; i++) {
            if (isUsed[i]) continue;
            if (cur != 0 && ans[cur - 1] > arr[i]) continue;
            isUsed[i] = true;
            ans[cur] = arr[i];
            func(cur + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        ans = new char[c];
        isUsed = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        func(0);

        bw.write(sb.toString());

        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}