import java.io.*;
import java.util.*;

public class Solution {
    static class BC {
        int x, y, c, p;
        BC(int x, int y, int c, int p) {
            this.x = x; this.y = y; this.c = c; this.p = p;
        }
    }

    // 이동: 0=제자리, 1=상,2=우,3=하,4=좌
    static final int[] dx = {0, 0, 1, 0, -1};
    static final int[] dy = {0, -1, 0, 1, 0};

    static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static ArrayList<Integer> reachable(int x, int y, BC[] bcs) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < bcs.length; i++) {
            if (dist(x, y, bcs[i].x, bcs[i].y) <= bcs[i].c) list.add(i);
        }
        // "아무 것도 선택 안함" 케이스를 위해 -1을 넣어둠
        list.add(-1);
        return list;
    }

    static int bestSum(ArrayList<Integer> aList, ArrayList<Integer> bList, BC[] bcs) {
        int best = 0;
        for (int ai : aList) {
            for (int bi : bList) {
                int sum;
                if (ai == -1 && bi == -1) sum = 0;
                else if (ai == -1) sum = bcs[bi].p;
                else if (bi == -1) sum = bcs[ai].p;
                else if (ai == bi) sum = bcs[ai].p;          // 같은 BC면 한번만
                else sum = bcs[ai].p + bcs[bi].p;            // 다른 BC면 합
                if (sum > best) best = sum;
            }
        }
        return best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            int[] moveA = new int[M];
            int[] moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveA[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) moveB[i] = Integer.parseInt(st.nextToken());

            BC[] bcs = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[i] = new BC(x, y, c, p);
            }

            // 초기 위치: A(1,1), B(10,10)
            int ax = 1, ay = 1;
            int bx = 10, by = 10;

            int ans = 0;

            // 0초(이동 전)도 충전 계산
            ArrayList<Integer> aList0 = reachable(ax, ay, bcs);
            ArrayList<Integer> bList0 = reachable(bx, by, bcs);
            ans += bestSum(aList0, bList0, bcs);

            // 1초 ~ M초
            for (int t = 0; t < M; t++) {
                ax += dx[moveA[t]];
                ay += dy[moveA[t]];
                bx += dx[moveB[t]];
                by += dy[moveB[t]];

                ArrayList<Integer> aList = reachable(ax, ay, bcs);
                ArrayList<Integer> bList = reachable(bx, by, bcs);
                ans += bestSum(aList, bList, bcs);
            }

            out.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}
