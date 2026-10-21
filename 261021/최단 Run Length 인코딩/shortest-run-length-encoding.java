import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int calc(String A, int shift, int n) {
        String s = "";
        char c = '\0';
        int ct = 0;

        for (int i = shift; i < shift + n; i++) {
            if (ct == 0) {
                c = A.charAt(i);
                ct = 1;
                continue;
            }

            if (c != A.charAt(i)) {
                s += c;
                s += ct;
                c = A.charAt(i);
                ct = 1;
            } else {
                ct++;
            }
        }

        if (ct > 0) {
            s += c;
            s += ct;
        }

        return s.length();
    }

    public static void main(String[] args) throws Exception {
        int ans = Integer.MAX_VALUE;
        String s = br.readLine();

        sb.append(s);
        sb.append(s);
        String A = sb.toString();

        int n = s.length();

        for (int shift = 0; shift < n; shift++) {
            ans = Math.min(ans, calc(A, shift, n));
        }

        System.out.println(ans);
    }
}