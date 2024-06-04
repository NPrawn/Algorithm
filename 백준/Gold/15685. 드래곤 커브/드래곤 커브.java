import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, ans = 0;
    static int[][] map = new int[101][101];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void dragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> v = new ArrayList<>();
        v.add(d);

        while (g-- > 0) {
            int vSize = v.size();
            for (int j = vSize - 1; j >= 0; j--) {
                v.add((v.get(j) + 1) % 4);
            }
        }
        for (int dir : v) {
            x += dx[dir];
            y += dy[dir];
            map[x][y] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            dragonCurve(x, y, d, g);
        }


        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] != 1) continue;
                if (map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) ans++;
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}