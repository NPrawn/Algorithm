import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, peopleCnt, ans;
    static ArrayList<int[]> people;
    static int[][] stairs;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(input.readLine());

            people = new ArrayList<>();
            stairs = new int[2][3];
            int stairIdx = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(input.readLine());
                for (int j = 0; j < N; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == 1) {
                        people.add(new int[]{i, j});
                    } else if (v >= 2) {
                        stairs[stairIdx][0] = i;
                        stairs[stairIdx][1] = j;
                        stairs[stairIdx][2] = v;
                        stairIdx++;
                    }
                }
            }

            peopleCnt = people.size();
            selected = new int[peopleCnt];
            ans = Integer.MAX_VALUE;

            dfs(0);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == peopleCnt) {
            simulate();
            return;
        }

        selected[depth] = 0;
        dfs(depth + 1);

        selected[depth] = 1;
        dfs(depth + 1);
    }

    static void simulate() {
        ArrayList<Integer> stair0 = new ArrayList<>();
        ArrayList<Integer> stair1 = new ArrayList<>();

        for (int i = 0; i < peopleCnt; i++) {
            int[] p = people.get(i);
            int s = selected[i];

            int dist = Math.abs(p[0] - stairs[s][0]) + Math.abs(p[1] - stairs[s][1]);

            if (s == 0) stair0.add(dist);
            else stair1.add(dist);
        }

        int t0 = down(stair0, stairs[0][2]);
        int t1 = down(stair1, stairs[1][2]);

        ans = Math.min(ans, Math.max(t0, t1));
    }

    static int down(ArrayList<Integer> list, int len) {
        if (list.isEmpty()) return 0;

        Collections.sort(list);

        int size = list.size();
        int[] finish = new int[size];

        for (int i = 0; i < size; i++) {
            int start = list.get(i) + 1;

            if (i >= 3) {
                start = Math.max(start, finish[i - 3]);
            }

            finish[i] = start + len;
        }

        return finish[size - 1];
    }
}