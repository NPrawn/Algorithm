import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int n = Integer.parseInt(input.readLine());
			ArrayList<Integer> op = new ArrayList<>();
			st = new StringTokenizer(input.readLine());
			for (int i = 0; i < 4; i++) {
				int k = Integer.parseInt(st.nextToken());
				while (k-- > 0)
					op.add(i);
			}

			ArrayList<Integer> arr = new ArrayList<>();
			st = new StringTokenizer(input.readLine());
			while (st.hasMoreTokens())
				arr.add(Integer.parseInt(st.nextToken()));
			
			Collections.sort(op);
			do {
				int res = arr.get(0);
				for (int i =1; i<n; i++) {
					int cmd = op.get(i-1);
					if (cmd==0)
						res += arr.get(i);
					else if (cmd==1)
						res -= arr.get(i);
					else if (cmd==2)
						res *= arr.get(i);
					else
						res /= arr.get(i);
				}
				min = Math.min(min, res);
				max = Math.max(max, res);
				
			} while (nextPermutation(op));
			
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb.toString());
	}

	static boolean nextPermutation(List<Integer> a) {
		int n = a.size();
		int i = n - 2;
		while (i >= 0 && a.get(i) >= a.get(i + 1))
			i--;
		if (i < 0)
			return false;

		int j = n - 1;
		while (a.get(i) >= a.get(j))
			j--;

		int tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);

		int l = i + 1, r = n - 1;
		while (l < r) {
			int t = a.get(l);
			a.set(l, a.get(r));
			a.set(r, t);
			l++;
			r--;
		}
		return true;
	}
}