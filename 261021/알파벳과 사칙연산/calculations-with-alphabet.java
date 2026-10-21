import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s;
    static int[] arr = new int[6];
    static int ans = Integer.MIN_VALUE;

    static int calc() {
        int result = arr[s.charAt(0) - 'a'];

        for (int i = 1; i < s.length(); i += 2) {
            char op = s.charAt(i);
            int num = arr[s.charAt(i + 1) - 'a'];

            if (op == '+') {
                result += num;
            } else if (op == '-') {
                result -= num;
            } else if (op == '*') {
                result *= num;
            }
        }

        return result;
    }

    static void dfs(int depth) {
        if (depth == 6) {
            ans = Math.max(ans, calc());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        s = br.readLine();

        dfs(0);

        System.out.println(ans);
    }
}