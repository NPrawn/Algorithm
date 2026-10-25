
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] parent, size;
    static boolean[] cycle;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        // 이미 같은 연결 요소라면 사이클 발생
        if (pa == pb) {
            cycle[pa] = true;
            return;
        }

        if (size[pa] < size[pb]) {
            int tmp = pa;
            pa = pb;
            pb = tmp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];

        // 기존 사이클 여부도 합쳐야 함
        cycle[pa] = cycle[pa] || cycle[pb];
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];
        cycle = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (find(i) == i && !cycle[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
