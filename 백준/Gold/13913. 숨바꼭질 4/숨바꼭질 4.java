import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n, k, dx[] = {-1, 1};
    static boolean vis[];
    static Node ans;
    static int route[];

    static class Node {
        int x;
        int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    public static Node bfs() {
        Queue<Node> que = new LinkedList<>();
        int[] array = new int[1];
        int idx = 0;
        Array.set(array, idx++, n);
        que.add(new Node(n, 0));

        while(!que.isEmpty()){
            Node cur = que.poll();
            if (cur.x == k) {
                return cur;
            }
            for (int dir = 0; dir < 3; dir++) {
                int nx;
                if (dir == 2) {
                    nx = cur.x * 2;
                } else {
                    nx = cur.x + dx[dir];
                }

                if (nx < 0 || nx >= 100010) {
                    continue;
                }
                if (vis[nx]) {
                    continue;
                }
                vis[nx] = true;
                que.add(new Node(nx, cur.dist + 1));
                route[nx] = cur.x;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        vis = new boolean[100010];
        route = new int[100010];

        ans = bfs();

        bw.write(ans.dist + "\n");
        int idx = k;
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        while (idx != n) {
            stack.push(route[idx]);
            idx = route[idx];
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }
}