import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static int[] piece = new int[10];
    static int[] dice = new int[10];
    static int[] map = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0,
            10, 13, 16, 19, 25, 30, 35, 40, 0,
            20, 22, 24, 25, 30, 35, 40, 0,
            30, 28, 27, 26, 25, 30, 35, 40, 0};


    static void game() {
        boolean[] visited = new boolean[map.length];
        int score = 0;
        int[] p = new int[4];
        for (int i = 0; i < 10; i++) {
            int nd = dice[i];
            int np = piece[i];
            if (isFinish(p[np])) return;

            int next = nextPoint(p[np], nd);
            if (isFinish(next)) {
                setVisited(visited, p[np], false);
                p[np] = next;
                continue;
            }
            if (visited[next]) return;
            setVisited(visited, p[np], false);
            setVisited(visited, next, true);

            p[np] = next;
            score += map[p[np]];
        }
        ans = Math.max(ans, score);
    }

    public static int nextPoint(int idx, int dice) {
        int next = idx + dice;

        if (idx < 21) {
            if (next >= 21) next = 21;
        } else if (idx < 30) {
            if (next >= 30) next = 30;
        } else if (idx < 38) {
            if (next >= 38) next = 38;
        } else if (idx < 47) {
            if (next >= 47) next = 47;
        }

        if (next == 5) return 22;
        if (next == 10) return 31;
        if (next == 15) return 39;
        return next;
    }

    static void setVisited(boolean[] visited, int idx, boolean check) {
        if (idx == 20 || idx == 29 || idx == 37 || idx == 46) {
            visited[20] = check;
            visited[29] = check;
            visited[37] = check;
            visited[46] = check;
        } else if (idx == 26 || idx == 34 || idx == 43) {
            visited[26] = check;
            visited[34] = check;
            visited[43] = check;
        } else if (idx == 27 || idx == 35 || idx == 44) {
            visited[27] = check;
            visited[35] = check;
            visited[44] = check;
        } else if (idx == 28 || idx == 36 || idx == 45) {
            visited[28] = check;
            visited[36] = check;
            visited[45] = check;
        } else {
            visited[idx] = check;
        }
    }

    static boolean isFinish(int idx) {
        return idx == 21 || idx == 30 || idx == 38 || idx == 47;
    }

    static void permutation(int cur) {
        if (cur == 10) {
            game();
            return;
        }
        for (int i = 0; i < 4; i++) {
            piece[cur] = i;
            permutation(cur + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
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