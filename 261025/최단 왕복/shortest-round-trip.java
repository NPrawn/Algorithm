import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int[][] dist = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist[u][v] = Math.min(dist[u][v], d);
        }

        for (int k=0; k<=n; k++) {
            for (int i=0; i<=n; i++) {
                for (int j=0; j<=n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i=0; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE || dist[j][i] == Integer.MAX_VALUE) continue;
                ans = Math.min(dist[i][j] + dist[j][i], ans);
            }
        }

        System.out.println(ans);
    }
}