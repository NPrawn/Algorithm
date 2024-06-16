import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int ans = Integer.MAX_VALUE;
    static boolean[] check;

    static class Dot {
        int x, y, cnt;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Dot(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static class Node {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static void Permutation(int start, int depth, ArrayList<Node>[] adj_list, int sum, int dusts) {
        if (depth == dusts - 1) {
            ans = Math.min(ans, sum);
            return;
        }
        for (Node next : adj_list[start]) {
            if (check[next.end]) continue;
            check[next.end] = true;
            Permutation(next.end, depth + 1, adj_list, sum + next.weight, dusts);
            check[next.end] = false;
        }
    }

    static int bfs(Dot start, Dot end, int r, int c, char[][] map) {
        Queue<Dot> q = new LinkedList<>();
        boolean[][] vis = new boolean[r][c];
        q.offer(new Dot(start.x, start.y, 0));
        vis[start.y][start.x] = true;

        while (!q.isEmpty()) {
            Dot d = q.poll();
            if (d.y == end.y && d.x == end.x) {
                return d.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = d.x + dx[i];
                int ny = d.y + dy[i];
                if (nx < 0 || nx >= c || ny < 0 || ny >= r || vis[ny][nx] || map[ny][nx] == 'x') continue;
                q.offer(new Dot(nx, ny, d.cnt + 1));
                vis[ny][nx] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            ans = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r + c == 0) break;

            char[][] map = new char[r][c];
            Dot[] dusts = new Dot[11];
            int dust_idx = 1;

            for (int i = 0; i < r; i++) {
                String str = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'o') {
                        dusts[0] = new Dot(j, i);
                    } else if (map[i][j] == '*') {
                        dusts[dust_idx++] = new Dot(j, i);
                    }
                }
            }

            ArrayList<Node>[] adj_list = new ArrayList[dust_idx];
            for (int i = 0; i < dust_idx; i++) {
                adj_list[i] = new ArrayList<>();
            }
            for (int start = 0; start < dust_idx - 1; start++) {
                for (int end = start + 1; end < dust_idx; end++) {
                    int weight = bfs(dusts[start], dusts[end], r, c, map);
                    if (weight == -1) continue;
                    adj_list[start].add(new Node(end, weight));
                    adj_list[end].add(new Node(start, weight));

                }
            }
            check = new boolean[dust_idx];
            check[0] = true;
            Permutation(0, 0, adj_list, 0, dust_idx);

            sb.append(ans == Integer.MAX_VALUE ? -1 : ans);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}