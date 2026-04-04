import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		int[] arr = new int[n+1];
		st = new StringTokenizer(input.readLine());
		int sum = 0;
		for (int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for (int i=0; i<n+1; i++)
			adj[i] = new ArrayList<>();

		for (int i=1; i<=n;	i++) {
			st = new StringTokenizer(input.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j=0; j<k; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int full = (1 << n) - 1;
		int ans = Integer.MAX_VALUE;
		for (int mask=1; mask<=full; mask++) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			
			for (int i=0; i<n; i++) {
				if ((mask & (1 << i)) != 0) A.add(i+1);
				else B.add(i+1);
			}
			if (A.size() == 0 || B.size() == 0) continue;
			
			boolean[] vis = new boolean[n+1];
			vis[A.get(0)] = true;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			int ct = 0;
			q.add(A.get(0));
			while (!q.isEmpty()) {
				int now = q.pollFirst();
				ct += arr[now];
				for (int nxt : adj[now]) {
					if (vis[nxt]) continue;
					if (B.contains(nxt)) continue;
					
					vis[nxt] = true;
					q.add(nxt);
				}
			}
			int cnt = 0;
			for (int i=1; i<=n; i++) {
				if (!vis[i]) continue;
				cnt += 1;
			}
			
			
			if (cnt != A.size()) continue;
			
			vis = new boolean[n+1];
			vis[B.get(0)] = true;
			q = new ArrayDeque<>();
			q.add(B.get(0));
			while (!q.isEmpty()) {
				int now = q.pollFirst();
				for (int nxt : adj[now]) {
					if (vis[nxt]) continue;
					if (A.contains(nxt)) continue;
					
					vis[nxt] = true;
					q.add(nxt);
				}
			}
			cnt = 0;
			for (int i=1; i<=n; i++) {
				if (!vis[i]) continue;
				cnt += 1;
			}
			if (cnt != B.size()) continue;
			
			ans = Math.min(ans, Math.abs((sum-ct) - ct));
		}
		
		if (ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
}
