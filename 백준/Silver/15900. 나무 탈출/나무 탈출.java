import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++)
			adj[i] = new ArrayList();
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		Deque<Integer> dq = new ArrayDeque<>();
		dist[1] = 0;
		dq.addLast(1);
		
		int max = 0;
		boolean[] leaf = new boolean[n+1];
		Arrays.fill(leaf, true);
		while (!dq.isEmpty()) {
			int now = dq.pollFirst();
			for (int v : adj[now]) {
				if (dist[v] != -1)
					continue;
				dist[v] = dist[now] + 1;
				max = dist[v];
				leaf[now] = false;
				dq.addLast(v);
			}
		}

		int ans = 0;
		for (int i=1; i<n+1;i++) {
			if (leaf[i]) {
				ans += dist[i];
			}
		}
		
		System.out.println(ans % 2 == 0 ? "No" : "Yes");

	}
}
