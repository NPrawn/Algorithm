import java.io.*;
import java.util.*;

public class Main {
    static int n, m, g, r;
    static int[][] garden;
    static List<int[]> possibleLands;
    static int[] selected;
    static int[] greenSelected;
    static int answer;

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node {
        int r, c, t;
        char color;

        Node(int r, int c, int t, char color) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.color = color;
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    static void selectLand(int start, int count) {
        if (count == (g + r)) {
            selectGreen(0, 0);
            return;
        }

        for (int i = start; i < possibleLands.size(); i++) {
            selected[count] = i;
            selectLand(i + 1, count + 1);
        }
    }

    static void selectGreen(int start, int count) {
        if (count == g) {
            bfs();
            return;
        }

        for (int i = start; i < g + r; i++) {
            greenSelected[count] = i;
            selectGreen(i + 1, count + 1);
        }
    }

    static void bfs() {
        int[][] greenTime = new int[n][m];
        int[][] redTime = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < g + r; i++) {
            boolean check = false;

            for (int j = 0; j < g; j++) {
                if (greenSelected[j] == i) {
                    check = true;
                }
            }

            if (check) {
                int[] land = possibleLands.get(selected[i]);
                greenTime[land[0]][land[1]] = 1;
                q.offer(new Node(land[0], land[1], 1, 'G'));
                continue;
            }
            int[] land = possibleLands.get(selected[i]);
            redTime[land[0]][land[1]] = 1;
            q.offer(new Node(land[0], land[1], 1, 'R'));
        }

        int count = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if (greenTime[now.r][now.c] == redTime[now.r][now.c]) {
                continue;
            }
            for (int[] d : directions) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if (!check(nr, nc)) {
                    continue;
                }
                if (garden[nr][nc] == 0) {
                    continue;
                }

                if (now.color == 'G') {
                    if (greenTime[nr][nc] > 0) {
                        continue;
                    }

                    if (redTime[nr][nc] > 0 && redTime[nr][nc] <= now.t) {
                        continue;
                    }
                    greenTime[nr][nc] = now.t + 1;

                    if (redTime[nr][nc] == now.t + 1) {
                        count++;
                        continue;
                    }
                    q.offer(new Node(nr, nc, now.t + 1, now.color));
                    continue;
                }

                if (redTime[nr][nc] > 0) {
                    continue;
                }

                if (greenTime[nr][nc] > 0 && greenTime[nr][nc] <= now.t) {
                    continue;
                }
                redTime[nr][nc] = now.t + 1;

                if (greenTime[nr][nc] == now.t + 1) {
                    count++;
                    continue;
                }

                q.offer(new Node(nr, nc, now.t + 1, now.color));
            }
        }

        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        garden = new int[n][m];
        possibleLands = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());

                if (garden[i][j] == 2) {
                    possibleLands.add(new int[]{i, j});
                }
            }
        }

        selected = new int[g + r];
        greenSelected = new int[g];
        selectLand(0, 0);

        bw.write(answer + "");
        br.close();
        bw.close();
    }
}