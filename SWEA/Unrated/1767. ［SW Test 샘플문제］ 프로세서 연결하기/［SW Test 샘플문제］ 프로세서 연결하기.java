import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bestConn, bestWire;

    static int coreCnt;
    static int[] coreX, coreY;

    static void f(int idx, int conn, int wire) {
        if (conn + (coreCnt - idx) < bestConn) return;

        if (idx == coreCnt) {
            if (conn > bestConn) {
                bestConn = conn;
                bestWire = wire;
            } else if (conn == bestConn) {
                if (wire < bestWire) bestWire = wire;
            }
            return;
        }

        int x = coreX[idx];
        int y = coreY[idx];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            int[] pathX = new int[n];
            int[] pathY = new int[n];
            int pathLen = 0;
            boolean ok = true;

            while (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (grid[nx][ny] != 0) {
                    ok = false;
                    break;
                }
                pathX[pathLen] = nx;
                pathY[pathLen] = ny;
                pathLen++;

                if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) break;

                nx += dx[d];
                ny += dy[d];
            }

            if (!ok) continue;
            if (pathLen == 0) continue;

            int px = pathX[pathLen - 1];
            int py = pathY[pathLen - 1];
            if (!(px == 0 || px == n - 1 || py == 0 || py == n - 1)) continue;

            for (int i = 0; i < pathLen; i++) {
                grid[pathX[i]][pathY[i]] = 2;
            }

            f(idx + 1, conn + 1, wire + pathLen);

            for (int i = 0; i < pathLen; i++) {
                grid[pathX[i]][pathY[i]] = 0;
            }
        }

        f(idx + 1, conn, wire);
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine().trim());
            grid = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            coreX = new int[n * n];
            coreY = new int[n * n];
            coreCnt = 0;

            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (grid[i][j] == 1) {
                        coreX[coreCnt] = i;
                        coreY[coreCnt] = j;
                        coreCnt++;
                    }
                }
            }

            bestConn = -1;
            bestWire = Integer.MAX_VALUE;

            f(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(bestWire).append("\n");
        }

        System.out.print(sb.toString());
    }
}
