import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, size, ans = 0;
    static ArrayList<int[][]> sticker = new ArrayList<>();
    static ArrayList<Node> stickerSize = new ArrayList<>();
    static int board[][];

    static boolean use(int a, int b, int[][] now, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (a + i >= n || b + j >= m) return false;
                if (board[a + i][b + j] == 1 && now[i][j] == 1) return false;
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[a + i][b + j] == 1) continue;
                board[a + i][b + j] = now[i][j];
            }
        }
        return true;
    }

    static void rotation(int cur) {
        int now[][] = sticker.get(cur);
        int x = stickerSize.get(cur).x;
        int y = stickerSize.get(cur).y;
        int res[][] = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                res[j][x - 1 - i] = now[i][j];
            }
        }
        sticker.set(cur, res);
        stickerSize.set(cur, new Node(y, x));
    }

    static void solve() {
        for (int t = 0; t < size; t++) {
            boolean done = false;
            for (int dir = 0; dir < 4; dir++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int now[][] = sticker.get(t);
                        int xSize = stickerSize.get(t).x;
                        int ySize = stickerSize.get(t).y;
                        if (use(i, j, now, xSize, ySize)) {
                            done = true;
                            break;
                        }
                    }
                    if (done) break;
                }
                if (done) break;
                rotation(t);
            }
        }
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = toInt(st.nextToken());
        m = toInt(st.nextToken());
        k = toInt(st.nextToken());
        board = new int[n][m];
        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());
            int arr[][] = new int[x][y];
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    arr[i][j] = toInt(st.nextToken());
                }
            }
            sticker.add(arr);
            stickerSize.add(new Node(x, y));
        }
        size = sticker.size();
        solve();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) ans++;
            }
        }

        bw.write(ans + "");
        bw.close();
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

}