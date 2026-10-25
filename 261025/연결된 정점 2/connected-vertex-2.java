import java.util.*;
import java.io.*;

public class Main {
    static int[] parent, size;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return size[a];

        if (size[a] < size[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];

        return size[a];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[100005];
        size = new int[100005];

        for (int i=0; i<100005; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(union(a, b));
        }
    }
}