import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 'B') continue;
            dq.add(i);
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (arr[i] != 'C') continue;
            if (dq.isEmpty()) break;
            if (dq.peek() > i) continue;
            used[i] = true;
            used[dq.poll()] = true;
            ans += 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (used[i]) continue;
            if (arr[i] != 'A') continue;
            if (dq.isEmpty()) break;
            if (dq.peekLast() < i) continue;
            used[i] = true;
            used[dq.pollLast()] = true;
            ans += 1;
        }

        System.out.println(ans);
    }
}