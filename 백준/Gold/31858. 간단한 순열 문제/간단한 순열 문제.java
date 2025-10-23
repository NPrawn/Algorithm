import java.io.*;
import java.util.*;

public class Main {
    static int n, ans = 0;
    static Stack<Integer> stack = new Stack<>();
    static TreeSet<Integer> set = new TreeSet<>();
    static Map<Integer, Integer> map = new HashMap<>();

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            stack.push(i + 1);
            map.put(v, i);
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int idx = map.get(p);
            set.add(idx);
            if (set.lower(idx) != null) {
                ans++;
            }
            if (set.higher(idx) != null) {
                ans++;
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}