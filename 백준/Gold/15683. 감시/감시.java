import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans, size, ct = 0, tmp = 0, qSize = 0;
    static int office[][];
    static ArrayList<Node> arr;
    static Queue<Node> q = new LinkedList<>();
    static Stack<Node> stack = new Stack<>();
    static Stack<Integer> sizeStack = new Stack<>();

    static class Node {
        int x, y;
        int type;

        Node(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static boolean check(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    static void right(int nx, int ny) {
        ny++;
        if (!check(nx, ny)) return;
        if (office[nx][ny] == 6) return;
        if (office[nx][ny] != -1) {
            office[nx][ny] = -1;
            stack.push(new Node(nx, ny, 0));
            qSize++;
            tmp++;
        }
        right(nx, ny);
    }

    static void down(int nx, int ny) {
        nx++;
        if (!check(nx, ny)) return;
        if (office[nx][ny] == 6) return;
        if (office[nx][ny] != -1) {
            office[nx][ny] = -1;
            stack.push(new Node(nx, ny, 0));
            qSize++;
            tmp++;
        }
        down(nx, ny);
    }

    static void left(int nx, int ny) {
        ny--;
        if (!check(nx, ny)) return;
        if (office[nx][ny] == 6) return;
        if (office[nx][ny] != -1) {
            office[nx][ny] = -1;
            stack.push(new Node(nx, ny, 0));
            qSize++;
            tmp++;
        }
        left(nx, ny);
    }

    static void up(int nx, int ny) {
        nx--;
        if (!check(nx, ny)) return;
        if (office[nx][ny] == 6) return;
        if (office[nx][ny] != -1) {
            office[nx][ny] = -1;
            stack.push(new Node(nx, ny, 0));
            qSize++;
            tmp++;
        }
        up(nx, ny);
    }

    static void rollBack() {
        int s = sizeStack.pop();
        while (s-- > 0) {
            Node v = stack.pop();
            office[v.x][v.y] = 0;
            tmp--;
        }
    }

    static void solve(int cur) {
        if (cur == size) {
            ct = Math.max(ct, tmp);
            return;
        }
        if (cur == 0) tmp = 0;
        Node now = arr.get(cur);
        if (now.type == 1) {
            for (int dir = 0; dir < 4; dir++) {
                qSize = 0;
                if (dir == 0) {
                    right(now.x, now.y);
                } else if (dir == 1) {
                    down(now.x, now.y);
                } else if (dir == 2) {
                    left(now.x, now.y);
                } else {
                    up(now.x, now.y);
                }
                sizeStack.push(qSize);
                solve(cur + 1);
                rollBack();
            }
        } else if (now.type == 2) {
            for (int dir = 0; dir < 2; dir++) {
                qSize = 0;
                if (dir == 0) {
                    right(now.x, now.y);
                    left(now.x, now.y);
                } else {
                    down(now.x, now.y);
                    up(now.x, now.y);
                }
                sizeStack.push(qSize);
                solve(cur + 1);
                rollBack();
            }
        } else if (now.type == 3) {
            for (int dir = 0; dir < 4; dir++) {
                qSize = 0;
                if (dir == 0) {
                    up(now.x, now.y);
                    right(now.x, now.y);
                } else if (dir == 1) {
                    right(now.x, now.y);
                    down(now.x, now.y);
                } else if (dir == 2) {
                    down(now.x, now.y);
                    left(now.x, now.y);
                } else {
                    left(now.x, now.y);
                    up(now.x, now.y);
                }
                sizeStack.push(qSize);
                solve(cur + 1);
                rollBack();
            }
        } else if (now.type == 4) {
            for (int dir = 0; dir < 4; dir++) {
                qSize = 0;
                if (dir == 0) {
                    left(now.x, now.y);
                    up(now.x, now.y);
                    right(now.x, now.y);
                } else if (dir == 1) {
                    up(now.x, now.y);
                    right(now.x, now.y);
                    down(now.x, now.y);
                } else if (dir == 2) {
                    right(now.x, now.y);
                    down(now.x, now.y);
                    left(now.x, now.y);
                } else {
                    down(now.x, now.y);
                    left(now.x, now.y);
                    up(now.x, now.y);
                }
                sizeStack.push(qSize);
                solve(cur + 1);
                rollBack();
            }
        } else if (now.type == 5) {
            qSize = 0;
            left(now.x, now.y);
            up(now.x, now.y);
            right(now.x, now.y);
            down(now.x, now.y);
            sizeStack.push(qSize);
            solve(cur + 1);
            rollBack();
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = n * m;
        arr = new ArrayList<>();
        office = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] != 6) {
                    arr.add(new Node(i, j, office[i][j]));
                    office[i][j] = -1;
                    ans--;
                }
                if (office[i][j] == 6) {
                    ans--;
                }
            }
        }
        size = arr.size();

        solve(0);

        bw.write((ans - ct) + "");

        br.close();
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}