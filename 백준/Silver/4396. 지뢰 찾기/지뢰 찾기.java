import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static char[][] grid;
    static char[][] ans;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        ans = new char[n][n];
        boolean boom = false;

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for (int x = 0; x < n; x++) {
            char[] arr = br.readLine().toCharArray();
            for (int y = 0; y < n; y++) {
                char c = arr[y];
                if (c == '.'){
                    ans[x][y] = '.';
                    continue;
                }
                if (grid[x][y] == '*') {
                    ans[x][y] = '*';
                    boom = true;
                    continue;
                }
                int ct = 0;
                for (int d = 0; d < 8; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                    if (grid[nx][ny] == '*') ct+=1;
                }

                ans[x][y] = (char) (ct + '0');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*' && boom) {
                    ans[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}