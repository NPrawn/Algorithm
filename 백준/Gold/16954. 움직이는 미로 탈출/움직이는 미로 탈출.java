import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1,-1,-1,0,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] maze = new char[8][8];

        for (int i=0;i<8;i++){
            maze[i] = br.readLine().toCharArray();
        }

        if (bfs(maze))
            System.out.println("1");
        else
            System.out.println("0");

    }

    public static boolean bfs(char[][] maze) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{7, 0});

        int t = 0;
        while (!q.isEmpty()) {
            if (t >= 8) return true;
            int size = q.size();
            boolean[][] vis = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                if (maze[x][y] == '#') continue;
                if (x==0 && y == 7) return true;

                for (int d = 0; d < 9; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                        continue;
                    }
                    if (maze[nx][ny] == '#') continue;
                    if (nx-1 >= 0 && maze[nx-1][ny] == '#') continue;

                    if (vis[nx][ny]) continue;
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
            moveWalls(maze);
            t++;
        }
        return false;
    }

    public static void moveWalls(char[][] maze) {
        for (int i = 7; i > 0; i--) {
            maze[i] = maze[i-1].clone();
        }
        Arrays.fill(maze[0], '.');
    }
}