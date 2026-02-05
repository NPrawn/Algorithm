import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, x, m;
	static int[] arr;
	static int[][] cmds;
	static ArrayList<int[]> ans;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = new ArrayList<>();
			st = new StringTokenizer(input.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			cmds = new int[m][3];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(input.readLine());
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				cmds[i][0] = l;
				cmds[i][1] = r;
				cmds[i][2] = s;
			}

			dfs(0);

			if (ans.size() == 0) {
				sb.append("#").append(tc).append(" ");
				sb.append("-1");
				sb.append("\n");
			}
			int max = 0;
			for (int i=0; i<ans.size();i++) {
				int res = 0;
				for (int e : ans.get(i))
					res += e;
				max = Math.max(max, res);
			}
			
			for (int i=ans.size()-1; i>=0; i--) {
				int res = 0;
				for (int e : ans.get(i))
					res += e;
				if (res == max) {
					sb.append("#").append(tc).append(" ");
					for (int e : ans.get(i))
						sb.append(e).append(" ");
					sb.append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void dfs(int depth) {
		if (depth == n) {
			int[] ps = new int[n + 1];
			for (int i = 1; i <= n; i++)
				ps[i] = ps[i - 1] + arr[i - 1];
			for (int i = 0; i < m; i++) {
				int res = ps[cmds[i][1]+1] - ps[cmds[i][0]];
				if (res != cmds[i][2]) return;
			}
//			System.out.println(Arrays.toString(arr));
			ans.add(arr.clone());
			return;
		}

		for (int i = x; i >= 0; i--) {
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
