import java.io.*;
import java.util.*;

public class Main {

    static final int NEG = -1_000_000_000;

    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
         * fromStart[i][j]
         * 시작점에서 (i, j)까지 얻을 수 있는 최대 이익
         * 현재 칸 포함
         */
        int[][] fromStart = new int[n][n];

        fromStart[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int best = NEG;

                if (i > 0) {
                    best = Math.max(best, fromStart[i - 1][j]);
                }

                if (j > 0) {
                    best = Math.max(best, fromStart[i][j - 1]);
                }

                fromStart[i][j] = best + grid[i][j];
            }
        }

        /*
         * toEnd[i][j]
         * (i, j)에서 도착점까지 얻을 수 있는 최대 이익
         * 현재 칸 포함
         */
        int[][] toEnd = new int[n][n];

        toEnd[n - 1][n - 1] = grid[n - 1][n - 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (i == n - 1 && j == n - 1) {
                    continue;
                }

                int best = NEG;

                if (i + 1 < n) {
                    best = Math.max(best, toEnd[i + 1][j]);
                }

                if (j + 1 < n) {
                    best = Math.max(best, toEnd[i][j + 1]);
                }

                toEnd[i][j] = best + grid[i][j];
            }
        }

        /*
         * bonus[i][j]
         * (i, j)에서 정확히 현재 step만큼 이동하면서
         * 추가로 얻을 수 있는 최대 이익
         *
         * 시작 칸 (i, j)의 값은 제외한다.
         */
        int[][] bonus = new int[n][n];

        // 0번 이동하면 추가 이익은 0
        // 자바 int 배열 기본값이 0이므로 별도 초기화 불필요

        for (int step = 1; step <= t; step++) {

            int[][] nextBonus = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(nextBonus[i], NEG);
            }

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    // 아래쪽으로 이동
                    if (i + 1 < n && bonus[i + 1][j] != NEG) {
                        nextBonus[i][j] = Math.max(
                                nextBonus[i][j],
                                grid[i + 1][j] + bonus[i + 1][j]
                        );
                    }

                    // 오른쪽으로 이동
                    if (j + 1 < n && bonus[i][j + 1] != NEG) {
                        nextBonus[i][j] = Math.max(
                                nextBonus[i][j],
                                grid[i][j + 1] + bonus[i][j + 1]
                        );
                    }
                }
            }

            bonus = nextBonus;
        }

        /*
         * 시간 여행 장치를 사용하지 않는 경우
         */
        int answer = fromStart[n - 1][n - 1];

        /*
         * 각 칸을 시간 여행 후 돌아오는 위치로 선택
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 이 칸에서 정확히 T번 이동할 수 없는 경우
                if (bonus[i][j] == NEG) {
                    continue;
                }

                int candidate =
                        fromStart[i][j]
                        + bonus[i][j]
                        + toEnd[i][j];

                answer = Math.max(answer, candidate);
            }
        }

        System.out.println(answer);
    }
}