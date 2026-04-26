import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String origin =  input.readLine();
            String pattern = input.readLine();

            int n = origin.length();
            int m = pattern.length();

            int[] pi = new int[m];

            int j = 0;

            for (int i = 1; i < m; i++) {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = pi[j - 1];
                }

                if (pattern.charAt(i) == pattern.charAt(j)) {
                    j += 1;
                    pi[i] = j;
                }
            }

            ArrayList<Integer> res = new ArrayList<>();
            j = 0;

            for (int i = 0; i < n; i++) {
                while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                    j = pi[j - 1];
                }

                if (origin.charAt(i) == pattern.charAt(j)) {
                    if (j == m - 1) {
                        res.add(i - m + 2);
                        j = pi[j];
                    } else {
                        j++;
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(res.size()).append("\n");
        }

        System.out.println(sb.toString());

    }
}