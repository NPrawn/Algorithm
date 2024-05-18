import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, board[][];
    static boolean visit[];
    static int min = Integer.MAX_VALUE;

    static void combi(int idx, int count) {
        if (count == n / 2) {
            diff();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    start += board[i][j];
                    start += board[j][i];
                } else if (!visit[j] && !visit[i]) {
                    link += board[i][j];
                    link += board[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        min = Math.min(val, min);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visit = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);

        bw.write(min + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}