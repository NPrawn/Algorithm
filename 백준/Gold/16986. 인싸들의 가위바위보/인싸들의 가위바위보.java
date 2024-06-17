import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans = 0;
    static int[][] map;
    static boolean[] isUsed;
    static int[] arr0;
    static int[] arr1;
    static int[] arr2;
    static int idx0 = 0;
    static int idx1 = 0;
    static int idx2 = 0;
    static Player p0;
    static Player p1;
    static Player p2;

    static class Player {
        ArrayList<Integer> arr = new ArrayList<>();
        int win;
        int seq;

        Player(int[] val, int win, int seq) {
            for (int i = 0; i < val.length; i++) {
                this.arr.add(val[i]);
            }
            this.win = win;
            this.seq = seq;
        }
    }

    static void permutation(int cur) {
        if (ans == 1) {
            return;
        }
        if (cur == n) {
            p0 = new Player(arr0, 0, 0);
            p1 = new Player(arr1, 0, 1);
            p2 = new Player(arr2, 0, 2);
            match();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isUsed[i]) continue;
            arr0[cur] = i;
            isUsed[i] = true;
            permutation(cur + 1);
            isUsed[i] = false;
        }
    }

    static void match() {
        Player winner = p0;
        Player loser = p1;
        Player waiter = p2;
        int res;
        while (true) {
            if (p0.win == k) {
                ans = 1;
                return;
            }
            if (p1.win == k || p2.win == k) {
                return;
            }
            if (p0.arr.isEmpty()) {
                return;
            }
            res = map[winner.arr.remove(0)][loser.arr.remove(0)];
            if (res == 0 || (res == 1 && loser.seq > winner.seq)) {
                loser.win++;
                Player tmp = winner;
                winner = loser;
                loser = waiter;
                waiter = tmp;
            } else {
                winner.win++;
                Player tmp = loser;
                loser = waiter;
                waiter = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isUsed = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        arr0 = new int[n];
        arr1 = new int[20];
        arr2 = new int[20];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < 20; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        permutation(0);


        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}