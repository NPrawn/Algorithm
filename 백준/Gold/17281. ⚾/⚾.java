import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = 0;
    static int[][] player;
    static int[] arr = new int[9];
    static boolean[] isUsed = new boolean[9];

    static void permutation(int cur) {
        if (cur == 3) {
            cur++;
        }
        if (cur == 9) {
            play();
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            arr[cur] = i;
            permutation(cur + 1);
            isUsed[i] = false;
        }
    }

    static void play() {
        int idx = -1;
        int score = 0;
        for (int t = 0; t < n; t++) {
            int out = 0;
            boolean[] base = new boolean[3];
            while (true) {
                idx++;
                if (idx == 9) idx = 0;
                int e = player[t][arr[idx]];
                if (e == 0) {
                    out++;
                    if (out == 3) break;
                    continue;
                }
                if (e == 4) {
                    score++;
                    for (int i = 0; i < 3; i++) {
                        if (base[i]) {
                            base[i] = false;
                            score++;
                        }
                    }
                    continue;
                }
                for (int i = 2; i >= 0; i--) {
                    if (base[i]) {
                        if (i + e >= 3) {
                            base[i] = false;
                            score++;
                        } else {
                            base[i + e] = true;
                            base[i] = false;
                        }
                    }
                }
                base[e - 1] = true;
            }
        }
        ans = Math.max(ans, score);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        player = new int[n][9];
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                player[t][i] = Integer.parseInt(st.nextToken());
            }
        }
        isUsed[0] = true;
        arr[3] = 0;
        permutation(0);

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}