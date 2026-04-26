import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, target;
	static int[] arr;
	static boolean check = false;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(input.readLine());
		target = 1;
		st = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++) {
			target *= Integer.parseInt(st.nextToken());
		}

		arr = new int[n];
		dfs(0);
		if (!check) {
			System.out.println(-1);
		} else {
			for (int e : arr) {
				System.out.print(e + " ");
			}
		}
	}

	static void dfs(int depth) {
		if (check)
			return;
		if (depth == n) {
			int res = 1;
			for (int e : arr) {
				res *= e;
			}

			if (res > target) {
				check = true;
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (check)
				return;
			arr[depth] = i;
			dfs(depth + 1);
		}
	}
}
