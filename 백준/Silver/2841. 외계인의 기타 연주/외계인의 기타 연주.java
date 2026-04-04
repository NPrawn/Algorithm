import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Deque<Integer>[] dq = new ArrayDeque[n+1];
        for (int i = 0; i < n+1; i++) {
            dq[i] = new ArrayDeque<>();
        }

        int ans = 0;

        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (dq[a].isEmpty()) {
                dq[a].addLast(k);
                ans+=1;
                continue;
            }

            while (!dq[a].isEmpty() && dq[a].peekLast() > k) {
                dq[a].pollLast();
                ans+=1;
            }

            if (!dq[a].isEmpty() && dq[a].peekLast() == k) {
                continue;
            }

            dq[a].addLast(k);
            ans += 1;
        }

        System.out.println(ans);
    }
}