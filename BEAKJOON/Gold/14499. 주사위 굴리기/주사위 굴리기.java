import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static Node dice;
    static int[] val;

    static void roll(int cmd) {
        int temp;
        switch (cmd) {
            case 1:
                temp = val[0];
                val[0] = val[4];
                val[4] = val[1];
                val[1] = val[5];
                val[5] = temp;
                return;
            case 2:
                temp = val[0];
                val[0] = val[5];
                val[5] = val[1];
                val[1] = val[4];
                val[4] = temp;
                return;
            case 3:
                temp = val[0];
                val[0] = val[2];
                val[2] = val[1];
                val[1] = val[3];
                val[3] = temp;
                return;
            case 4:
                temp = val[0];
                val[0] = val[3];
                val[3] = val[1];
                val[1] = val[2];
                val[2] = temp;
        }
    }

    static void move(int cmd) {
        int nx = dice.x + dx[cmd];
        int ny = dice.y + dy[cmd];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) return;
        dice.x = nx;
        dice.y = ny;
        roll(cmd);
        if (map[nx][ny] == 0) {
            map[nx][ny] = val[1];
        } else {
            val[1] = map[nx][ny];
            map[nx][ny] = 0;
        }
        sb.append(val[0]);
        sb.append("\n");
    }

    static class Node {
        int x, y;
        int floor;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.floor = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dice = new Node(x, y);
        val = new int[6];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        while (k-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            move(cmd);
        }

        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}