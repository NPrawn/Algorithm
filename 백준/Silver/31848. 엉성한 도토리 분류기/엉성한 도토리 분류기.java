import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, hole[], q, ans[];
    static Node acorn[];

    static class Node {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        hole = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hole[i] = Integer.parseInt(st.nextToken());
        }
        q = Integer.parseInt(br.readLine());
        acorn = new Node[q];
        ans = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            acorn[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(acorn, Comparator.comparingInt(o -> o.val));
        int idx = 0;
        for (int i = 0; i < q; i++) {
            int a = acorn[i].val;
            a -= idx;
            if (a <= hole[idx]) {
                ans[acorn[i].idx] = idx + 1;
                continue;
            }
            idx++;
            i--;
        }
        for (int e : ans) {
            sb.append(e + " ");
        }

        bw.write(sb.toString());
        bw.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}