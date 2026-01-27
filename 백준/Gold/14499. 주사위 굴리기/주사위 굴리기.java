import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, x, y, k;
    static int[][] grid;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        int bottom=0, top=0, up=0, down=0, left=0, right=0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd==2 && y-1 >= 0) {
                y-=1;
                int tmp = right;
                right = bottom;
                bottom = left;
                left = top;
                top = tmp;
                if (grid[x][y] != 0) {
                    bottom = grid[x][y];
                    grid[x][y] = 0;
                } else {
                    grid[x][y] = bottom;
                }
                sb.append(top).append("\n");
            } else if (cmd==1 && y+1 < m) {
                y+=1;
                int tmp = left;
                left = bottom;
                bottom = right;
                right = top;
                top = tmp;
                if (grid[x][y] != 0) {
                    bottom = grid[x][y];
                    grid[x][y] = 0;
                } else {
                    grid[x][y] = bottom;
                }
                sb.append(top).append("\n");
            } else if (cmd==4 && x+1 < n) {
                x+=1;
                int tmp = up;
                up = bottom;
                bottom = down;
                down = top;
                top = tmp;
                if (grid[x][y] != 0) {
                    bottom = grid[x][y];
                    grid[x][y] = 0;
                } else {
                    grid[x][y] = bottom;
                }
                sb.append(top).append("\n");
            } else if (cmd == 3 && x - 1 >= 0) {
                x -= 1;
                int tmp = down;
                down = bottom;
                bottom = up;
                up = top;
                top = tmp;
                if (grid[x][y] != 0) {
                    bottom = grid[x][y];
                    grid[x][y] = 0;
                } else {
                    grid[x][y] = bottom;
                }
                sb.append(top).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}