import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, k;
	static char[] arr;
	static HashSet<Character> A = new HashSet<>();
	static HashSet<Character> B = new HashSet<>();
	static boolean[] used;
	static char[] ans;

	public static void main(String[] args) throws Exception {

		B.add('a');
		B.add('e');
		B.add('i');
		B.add('o');
		B.add('u');
		for (int i = 0; i < 26; i++)
			A.add((char) ('a' + i));
		A.removeAll(B);
		
		st = new StringTokenizer(input.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		String[] s = input.readLine().split(" ");
		arr = new char[n];
		for (int i=0; i<n; i++) {
			arr[i] = s[i].charAt(0);
		}
		ans = new char[k];
		used = new boolean[n];
		Arrays.sort(arr);

		dfs(0);
		
		System.out.println(sb.toString());
	}

	static void dfs(int depth) {
		if (depth == k) {
			String s = "";
			for (char e : ans) {
				s += e;
			}
			int ct1 = 0;
			int ct2 = 0;
			for (char c : s.toCharArray()) {
				if (B.contains(c)) ct1 += 1;
				if (A.contains(c)) ct2 += 1;
			}
			if (ct1 < 1) return;
			if (ct2 < 2) return;
			sb.append(s).append('\n');
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (used[i]) continue;
			if (depth != 0 && ans[depth - 1] > arr[i]) continue;
			used[i] = true;
			ans[depth] = arr[i];
			dfs(depth + 1);
			used[i] = false;
		}
	}
}