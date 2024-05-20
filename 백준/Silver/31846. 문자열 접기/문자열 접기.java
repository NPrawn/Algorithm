import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, q, l, r, tmp = 0, ans = 0;
    static char board[];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new char[n + 1];
        String s = br.readLine();
        for (int i = 1; i <= n; i++) {
            board[i] = s.charAt(i - 1);
        }
        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            char arr[] = new char[r - l + 2];
            char arr1[];
            char arr2[];
            int k = 1;
            for (int i = l; i <= r; i++) {
                arr[k++] = board[i];
            }
            int idx = r - l;
            while (idx > 0) {
                tmp = 0;
                arr1 = new char[n];
                arr2 = new char[n];
                Arrays.fill(arr1, '0');
                Arrays.fill(arr2, '0');
                int j = idx;
                for (int i = 1; i <= r - l + 1; i++) {
                    if (idx > (r - l) / 2) {
                        if (i <= idx) {
                            arr1[i] = arr[i];
                        } else {
                            arr2[j--] = arr[i];
                        }
                    } else {
                        if (i <= idx) {
                            arr1[r - l - idx + i - 1] = arr[i];
                        } else {
                            arr2[r - l - i + idx] = arr[i];
                        }
                    }
                }
                for (int i = 1; i < n; i++) {
                    if (arr1[i] == '0' || arr2[i] == '0') {
                        continue;
                    }
                    if (arr1[i] == arr2[i]) {
                        tmp++;
                    }
                }
                ans = Math.max(ans, tmp);
                idx--;
            }
            bw.write(ans + "\n");
        }

        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}