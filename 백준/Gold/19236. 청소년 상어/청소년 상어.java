import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[4][4];
        int[] fd = new int[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                fd[map[i][j]] = Integer.parseInt(st.nextToken()) - 1;
            }
        }
        int eat = map[0][0];
        int sd = fd[eat];
        map[0][0] = 'S';
        dfs(0, 0, eat, sd, map, fd);
        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static void dfs(int x, int y, int eat, int sd, int[][] map, int[] fd) {
        ans = Math.max(ans, eat);
        int[] p = new int[17];
        f:
        for (int f = 1; f <= 16; f++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[i][j] == f) {
                        for (int d = 0; d < 8; d++) {
                            int ni = i + dx[(d + fd[f]) % 8];
                            int nj = j + dy[(d + fd[f]) % 8];
                            if (ni < 0 || nj < 0 || ni >= 4 || nj >= 4 || map[ni][nj] == 'S') continue;
                            map[i][j] = map[ni][nj];
                            map[ni][nj] = f;
                            p[f] = (fd[f] + d) % 8;
                            continue f;
                        }
                        p[f] = (7 + fd[f]) % 8;
                        continue f;
                    }
                }
            }
        }
        map[x][y] = 0;
        for (int d = 1; d <= 3; d++) {
            int nx = x + d * dx[sd];
            int ny = y + d * dy[sd];
            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;

            if (map[nx][ny] == 0) continue;

            int[][] pass = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    pass[i][j] = map[i][j];
                }
            }
            int tmp = pass[nx][ny];
            pass[nx][ny] = 'S';
            dfs(nx, ny, eat + tmp, p[tmp], pass, p);
        }
    }
}