import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean check(int x1, int y1, int x2, int y2, int[][] grid) {
        for (int x=x1; x<=x2; x++) {
            for (int y=y1; y<=y2; y++) {
                if (grid[x][y] <= 0) return false;
            }
        }


        return true;
    }

    public static void main(String[] args) throws Exception{
        int n, m;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int answer = -1;
    
        int[][] grid = new int[n][m];
        for (int x=0; x<n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<m; y++) {
                grid[x][y] = Integer.parseInt(st.nextToken());
            }
        }


        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                for (int a=x; a<n; a++) {
                    for (int b=y; b<m; b++) {
                        if (check(x,y,a,b,grid)) {
                            int area = (a-x+1) * (b-y+1);
                            answer = Math.max(answer, area);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}