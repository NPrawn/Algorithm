import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M, ans = 0;
    static int[][] map;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static ArrayList<Shark> sharks = new ArrayList<>();
    static Node man = new Node(0, 0);

    static class Shark {
        int x, y;
        int s, d, z;

        Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void fishing() {
        int ny = man.y;
        for (int i = 0; i < R; i++) {
            for (Shark s : sharks) {
                if (s.x == i && s.y == ny) {
                    ans += s.z;
                    sharks.remove(s);
                    return;
                }
            }
        }
    }

    static void move() {
        for (Shark shark : sharks) {
            for (int i = 0; i < shark.s; i++) {
                shark.x += dx[shark.d];
                shark.y += dy[shark.d];
                if (shark.x < 0) {
                    shark.x = 1;
                    shark.d = 2;
                }
                if (shark.y < 0) {
                    shark.y = 1;
                    shark.d = 3;
                }
                if (shark.x >= R) {
                    shark.x = R - 2;
                    shark.d = 1;
                }
                if (shark.y >= C) {
                    shark.y = C - 2;
                    shark.d = 4;
                }
            }
        }


        Shark[][] board = new Shark[R][C];
        for (Shark s1 : sharks) {
            if (board[s1.x][s1.y] != null) {
                if (board[s1.x][s1.y].z > s1.z) {
                    continue;
                }
            }
            board[s1.x][s1.y] = s1;
        }
        sharks.clear();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != null) {
                    sharks.add(board[i][j]);
                    map[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R][C];


        int x, y, s, d, z;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            if (d == 1 || d == 2) {
                s %= (R - 1) * 2;
            } else {
                s %= (C - 1) * 2;
            }
            sharks.add(new Shark(x, y, s, d, z));
            map[x][y] = 1;
        }
        for (int t = 0; t < C; t++) {
            man.y = t;
            fishing();
            move();
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}