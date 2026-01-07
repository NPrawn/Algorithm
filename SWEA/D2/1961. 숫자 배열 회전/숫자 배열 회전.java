import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] R90 = new int[n][n];
            int[][] R180 = new int[n][n];
            int[][] R270 = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    R90[j][n - 1 - i] = grid[i][j];
                    R180[n - 1 - i][n - 1 - j] = grid[i][j];
                    R270[n - 1 - j][i] = grid[i][j];
                }
            }

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(R90[i][j]);
                }
                sb.append(" ");

                for (int j = 0; j < n; j++) {
                    sb.append(R180[i][j]);
                }
                sb.append(" ");

                for (int j = 0; j < n; j++) {
                    sb.append(R270[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}