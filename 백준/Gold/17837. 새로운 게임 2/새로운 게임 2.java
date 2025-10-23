import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, k, ans = 0;
    static int[][] color;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static LinkedList<Integer>[][] map;
    static Horse[] horse;

    static class Horse {
        int x, y, d;

        Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static void game() {
        for (int t = 1; t <= 1000; t++) {
            for (int j = 0; j < k; j++) {
                int x = horse[j].x;
                int y = horse[j].y;
                int d = horse[j].d;
                int num = searchOrder(j, x, y);

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2) {
                    horse[j].d++;
                    if (horse[j].d == 3) horse[j].d = 1;
                    if (horse[j].d == 5) horse[j].d = 3;
                    d = horse[j].d;
                    nx = x + dx[horse[j].d];
                    ny = y + dy[horse[j].d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2) continue;
                }
                if (move(x, y, nx, ny, num, color[nx][ny])) {
                    ans = t;
                    return;
                }
            }
            ans = -1;
        }


    }

    static boolean move(int x, int y, int nx, int ny, int num, int order) {
        while (map[x][y].size() > num) {
            int temp = -1;
            if (order == 0) {
                temp = map[x][y].remove(num);
            } else {
                temp = map[x][y].removeLast();
            }
            horse[temp].x = nx;
            horse[temp].y = ny;
            map[nx][ny].add(temp);
        }
        return map[nx][ny].size() >= 4;
    }

    static int searchOrder(int n, int x, int y) {
        for (int i = 0; i < map[x][y].size(); i++) {
            if (map[x][y].get(i) == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        horse = new Horse[k];
        color = new int[n][n];
        map = new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            horse[i] = new Horse(x, y, d);
            map[x][y].add(i);
        }

        game();

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}