import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int[] arr = new int[e * 2];
			ArrayList<Integer>[] adj = new ArrayList[v + 1];
			int[] deg = new int[v + 1];
			for (int i = 0; i <= v; i++)
				adj[i] = new ArrayList<>();
			st = new StringTokenizer(input.readLine());
			for (int i=0; i<e*2;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < e*2; i+=2) {
				adj[arr[i]].add(arr[i+1]);
				deg[arr[i+1]]++;
			}
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			ArrayList<Integer> ans = new ArrayList<>();
			for (int i=1;i<=v;i++) {
				if (deg[i] == 0) {
					ans.add(i);
					dq.add(i);
				}
			}
			while(!dq.isEmpty()) {
				int now = dq.pollFirst();
				for (int nxt : adj[now]) {
					deg[nxt] -= 1;
					if (deg[nxt] == 0) {
						ans.add(nxt);
						dq.add(nxt);
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int a : ans) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
