import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int size = 2, eat = 0, ct = 0, sharkX = -1, sharkY = -1;
    static int minX, minY, minDist;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sharkX, sharkY));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 | ny < 0 | nx >= n || ny >= n) continue;
                if (map[nx][ny] > size) continue;
                if (dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;

                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    if (minDist > dist[nx][ny]) {
                        minDist = dist[nx][ny];
                        minX = nx;
                        minY = ny;
                    } else if (minDist == dist[nx][ny]) {
                        if (minX == nx) {
                            if (minY > ny) {
                                minY = ny;
                            }
                        } else if (minX > nx) {
                            minX = nx;
                            minY = ny;
                        }
                    }
                }

                q.offer(new Node(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            dist = new int[n][n];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs();

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                map[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                ct += dist[minX][minY];

                if (eat == size) {
                    size++;
                    eat = 0;
                }
            } else {
                break;
            }
        }

        sb.append(ct);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}