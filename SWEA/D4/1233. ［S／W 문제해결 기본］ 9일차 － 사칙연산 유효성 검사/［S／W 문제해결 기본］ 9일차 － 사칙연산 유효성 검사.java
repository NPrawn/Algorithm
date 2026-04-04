import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(input.readLine());
			sb.append("#").append(t).append(" ");
			ArrayList<String[]> tree = new ArrayList<>();
			boolean ans = true;
			boolean[] b = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				String[] s = input.readLine().split(" ");
				if (s.length == 4) {
					tree.add(s);
					continue;
				}
				if (s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/")) {
					ans = false;
				}
				b[i] = true;
			}

			if (!ans) {
				sb.append("0").append("\n");
				continue;
			}

			for (int i = tree.size() - 1; i > 0; i--) {
				String[] s = tree.get(i);
				if (!(s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/"))) {
					ans = false;
					break;
				}
				if(b[Integer.parseInt(s[2])] && b[Integer.parseInt(s[3])]) {
					b[Integer.parseInt(s[0])] = true;
				} else {
					ans = false;
					break;
				}
			}

			sb.append(ans ? "1" :"0").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}