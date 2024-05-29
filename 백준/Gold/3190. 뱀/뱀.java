import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, l, ans = 0;
    static int[][] map;
    static ArrayList<Pair> pairs = new ArrayList<>();
    static Snake head = new Snake(0, 0);
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Snake {
        int x, y, d;

        Snake(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = 1;
        }
    }

    static class Pair {
        int sec;
        char dir;

        Pair(int sec, char dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    static void rotate(char dir) {
        if (dir == 'L') {
            head.d--;
        } else {
            head.d++;
        }
        if (head.d == -1) head.d = 3;
        if (head.d == 4) head.d = 0;
    }

    static void run() {
        ArrayList<Snake> body = new ArrayList<>();
        body.add(new Snake(0, 0));
        Pair p = pairs.get(0);
        while (true) {
            Snake tail = new Snake(body.get(0).x, body.get(0).y);
            int nx = head.x + dx[head.d];
            int ny = head.y + dy[head.d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) return;
            if (map[nx][ny] == 1) return;
            if (map[nx][ny] != 2) {
                map[tail.x][tail.y] = 0;
                body.remove(0);
            }
            map[nx][ny] = 1;
            body.add(new Snake(nx, ny));
            head.x = nx;
            head.y = ny;

            ans++;
            if (ans == p.sec) {
                rotate(p.dir);
                pairs.remove(0);
                if (!pairs.isEmpty()) {
                    p = pairs.get(0);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 2;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            pairs.add(new Pair(s, c));
        }
        map[0][0] = 1;

        run();

        sb.append(ans + 1);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}