import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(input.readLine());

        for (int tc=1; tc<=T; tc++) {
    
            int n = Integer.parseInt(input.readLine());
            int m = Integer.parseInt(input.readLine());
            ArrayList<Integer>[] adj1 = new ArrayList[n+1];
            ArrayList<Integer>[] adj2 = new ArrayList[n+1];
            int ans = 0;
            for (int i=0; i<=n; i++){
                adj1[i] = new ArrayList<>();
                adj2[i] = new ArrayList<>();
            }
            for (int i=0;i<m; i++) {
                st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj1[a].add(b);
                adj2[b].add(a);
            }
    
            for (int i=1; i<n+1;i++) {
                int now = i;
                boolean[] vis = new boolean[n+1];
                vis[now] = true;
                int ct = 0;
                ArrayDeque<Integer> dq = new ArrayDeque<>();
                dq.add(now);
                while (!dq.isEmpty()) {
                    now = dq.pollFirst();
                    for (int nxt : adj1[now]) {
                        if (vis[nxt]) continue;
                        ct += 1;
                        dq.add(nxt);
                        vis[nxt] = true;
                    }
                }
                now = i;
                vis = new boolean[n+1];
                vis[now] = true;
                dq = new ArrayDeque<>();
                dq.add(now);
    
                while (!dq.isEmpty()) {
                    now = dq.pollFirst();
                    for (int nxt : adj2[now]) {
                        if (vis[nxt]) continue;
                        ct += 1;
                        dq.add(nxt);
                        vis[nxt] = true;
                    }
                }
    
                if (ct == n-1) ans += 1;
                
            }
    
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }


}