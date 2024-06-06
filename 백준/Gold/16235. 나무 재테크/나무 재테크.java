import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, ans = 0;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static ArrayList<Tree> tree = new ArrayList<>();
    static Queue<Tree> dead = new LinkedList<>();
    static int[][] arr;

    static class Tree {
        int x, y;
        int age;
        boolean dead;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
            this.dead = false;
        }
    }

    static class ageCom implements Comparator<Tree> {
        public int compare(Tree t1, Tree t2) {
            return Integer.compare(t1.age, t2.age);
        }
    }

    static void spring() {
        for (Tree t : tree) {
            if (t.dead) continue;
            int x = t.x;
            int y = t.y;
            if (map[x][y] < t.age) {
                dead.add(new Tree(t.x, t.y, t.age));
                t.dead = true;
                ans++;
                continue;
            }
            map[x][y] -= t.age;
            t.age++;
        }
    }

    static void summer() {
        while (!dead.isEmpty()) {
            Tree t = dead.poll();
            map[t.x][t.y] += t.age / 2;
        }
    }

    static void autumn() {
        ArrayList<Tree> newTree = new ArrayList<>();
        for (Tree t : tree) {
            if (t.dead) continue;
            if (t.age % 5 == 0) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = t.x + dx[dir];
                    int ny = t.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    newTree.add(new Tree(nx, ny, 1));
                }
            }
        }
        for (Tree t : tree) {
            if (t.dead) continue;
            newTree.add(t);
        }
        tree = newTree;
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += arr[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = 5;
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, age));
        }

        tree.sort(new ageCom());

        while (k-- > 0) {
            spring();
            summer();
            autumn();
            winter();
        }


        sb.append(tree.size());
        bw.write(sb.toString());
        bw.close();

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}