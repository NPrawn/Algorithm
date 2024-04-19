import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, year = 0, ct = 0;
    private static int[][] board;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] vis;
    private static int[][] amount;

    //좌표 저장 클래스
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //빙산 덩이 카운트
    public static int countIsland(){
        ct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || board[i][j] == 0) continue;
                bfs();
            }
        }
        return ct;
    }

    //bfs
    public static void bfs() {
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] > 0 && !vis[i][j]) {
                    que.add(new Pair(i, j));
                    vis[i][j] = true;
                    ct++;
                    while (!que.isEmpty()) {
                        Pair cur = que.poll();
                        int w = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (board[nx][ny] == 0) {
                                w++;
                            }
                            if (vis[nx][ny] || board[nx][ny] == 0) continue;
                            que.add(new Pair(nx, ny));
                            vis[nx][ny] = true;
                        }
                        amount[cur.x][cur.y] = w;
                    }
                }
            }
        }


    }

    //빙산 녹이기
    public static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] -= amount[i][j];
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        vis = new boolean[n][m];
        amount = new int[n][m];

        //빙산 정보 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //빙산이 분리될때까지 반복
        while (true) {
            amount = new int[n][m];
            vis = new boolean[n][m];
            //분리 or 전부 없어지면 break
            countIsland();
            if (ct == 0) {
                bw.write("0\n");
                break;
            } else if (ct >= 2) {
                bw.write(Integer.toString(year) + "\n");
                break;
            }
            melt();
            year++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            }
        }

        br.close();
        bw.close();

    }
}