import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();

        int[] dxDir = { 1, 0, -1, 0 };
        int[] dyDir = { 0, 1, 0, -1 };

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] grid = new char[n][m];

            int x = 0, y = 0, d = 0;

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    char ch = line.charAt(j);
                    grid[i][j] = ch;

                    if (ch == '<' || ch == '>' || ch == '^' || ch == 'v') {
                        x = i; y = j;
                        if (ch == '<') d = 3;
                        else if (ch == '>') d = 1;
                        else if (ch == '^') d = 2;
                        else if (ch == 'v') d = 0;
                    }
                }
            }

            int k = Integer.parseInt(br.readLine().trim()); // 사용은 안 하지만 입력은 읽어야 함
            String cmdLine = br.readLine().trim();

            for (int idx = 0; idx < cmdLine.length(); idx++) {
                char c = cmdLine.charAt(idx);

                if (c == 'S') {
                    int sx = x, sy = y;
                    int dx = dxDir[d], dy = dyDir[d];

                    while (true) {
                        int nx = sx + dx;
                        int ny = sy + dy;

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;

                        if (grid[nx][ny] == '*') {
                            grid[nx][ny] = '.';
                            break;
                        }
                        if (grid[nx][ny] == '#') break;

                        sx = nx;
                        sy = ny;
                    }
                } else if (c == 'U') {
                    d = 2;
                    grid[x][y] = '^';
                    int nx = x + dxDir[d], ny = y + dyDir[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (grid[nx][ny] == '.') {
                        grid[nx][ny] = '^';
                        grid[x][y] = '.';
                        x = nx; y = ny;
                    }
                } else if (c == 'D') {
                    d = 0;
                    grid[x][y] = 'v';
                    int nx = x + dxDir[d], ny = y + dyDir[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (grid[nx][ny] == '.') {
                        grid[nx][ny] = 'v';
                        grid[x][y] = '.';
                        x = nx; y = ny;
                    }
                } else if (c == 'L') {
                    d = 3;
                    grid[x][y] = '<';
                    int nx = x + dxDir[d], ny = y + dyDir[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (grid[nx][ny] == '.') {
                        grid[nx][ny] = '<';
                        grid[x][y] = '.';
                        x = nx; y = ny;
                    }
                } else if (c == 'R') {
                    d = 1;
                    grid[x][y] = '>';
                    int nx = x + dxDir[d], ny = y + dyDir[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (grid[nx][ny] == '.') {
                        grid[nx][ny] = '>';
                        grid[x][y] = '.';
                        x = nx; y = ny;
                    }
                }
            }

            out.append("#").append(tc).append(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) out.append(grid[i][j]);
                out.append("\n");
            }
        }

        System.out.print(out.toString());
    }
}
