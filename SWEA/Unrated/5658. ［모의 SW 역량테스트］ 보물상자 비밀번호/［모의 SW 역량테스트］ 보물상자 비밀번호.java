import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			HashSet<Integer> ans = new HashSet<>();

			String s = input.readLine();
			ArrayDeque<Character> dq = new ArrayDeque<>();
			for (char c : s.toCharArray())
				dq.add(c);

			for (int t = 0; t < n; t++) {
				dq.add(dq.pollFirst());
				for (int j = 0; j < 4; j++) {
					String candi = "";
					for (int i = 0; i < n/4; i++)
						candi += dq.pollFirst();
						
					int res = Integer.parseInt(candi, 16);
					ans.add(res);
					for (char c : candi.toCharArray()) {
						dq.add(c);
					}
				}
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			for (int e : ans) {
				pq.add(e);
			}
			for (int i=1; i<k; i++) {
				pq.poll();
			}
			sb.append("#").append(tc).append(" ").append(pq.poll()).append("\n");
		}

		System.out.println(sb.toString());
	}
}