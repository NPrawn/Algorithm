import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, board[][], board2[][], ans;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean used[][];

    static boolean OOB(int a, int b) {
        return a < 0 || b < 0 || a >= n || b >= n;
    }

    static void move(int dir) {
        used = new boolean[n][n];
        if (dir == 0 || dir == 3) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int nx = i;
                    int ny = j;
                    int now = board2[i][j];
                    if (now == 0) continue;
                    while (true) {
                        nx += dx[dir];
                        ny += dy[dir];
                        if (OOB(nx, ny) || used[nx][ny]) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            board2[i][j] = 0;
                            board2[nx][ny] = now;
                            break;
                        }
                        if (board2[nx][ny] == 0) continue;
                        if (board2[nx][ny] != now) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            board2[i][j] = 0;
                            board2[nx][ny] = now;
                            break;
                        }
                        board2[nx][ny] = now * 2;
                        board2[i][j] = 0;
                        used[nx][ny] = true;
                        break;
                    }

                }
            }


        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int nx = i;
                    int ny = j;
                    int now = board2[i][j];
                    if (now == 0) continue;
                    while (true) {
                        nx += dx[dir];
                        ny += dy[dir];
                        if (OOB(nx, ny) || used[nx][ny]) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            board2[i][j] = 0;
                            board2[nx][ny] = now;
                            break;
                        }
                        if (board2[nx][ny] == 0) continue;
                        if (board2[nx][ny] != now) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            board2[i][j] = 0;
                            board2[nx][ny] = now;
                            break;
                        }
                        board2[nx][ny] = now * 2;
                        board2[i][j] = 0;
                        used[nx][ny] = true;
                        break;
                    }

                }
            }
        }

    }

    static void solve() {
        for (int tmp = 0; tmp < 1024; tmp++) {

            int brute = tmp;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                move(dir);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, board2[i][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        board2 = new int[n][n];
        used = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();


        bw.write(ans + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}