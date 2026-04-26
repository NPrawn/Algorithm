import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], 1000000);
            }
            int idx = 0;
            while (st.hasMoreElements()) {
                int k = Integer.parseInt(st.nextToken());
                if(k == 0) {
                    idx++;
                    continue;
                }
                dist[idx/n][idx%n] = k;
                idx++;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }

            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i==j) continue;
                    answer[i] += dist[i][j];
                }
            }
            sb.append("#").append(tc).append(" ").append(Arrays.stream(answer).min().getAsInt()).append('\n');
        }
        System.out.println(sb.toString());
    }

}