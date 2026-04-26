import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		ArrayList<Integer> C = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(input.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				q.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			} else {
				int menu = Integer.parseInt(st.nextToken());
				int[] cur = q.pollFirst();
				int student = cur[0];
				int prefer = cur[1];
				if (menu == prefer) {
					A.add(student);
				} else {
					B.add(student);
				}
			}
		}
		while (!q.isEmpty()) {
			int[] cur = q.pollFirst();
			C.add(cur[0]);
		}
		A.sort((a, b) -> a - b);
		B.sort((a, b) -> a - b);
		C.sort((a, b) -> a - b);
		for (int e : A) {
			System.out.print(e + " ");
		}
		if (A.size() == 0) {
			System.out.print("None");
		}
		System.out.println();
		for (int e : B) {
			System.out.print(e + " ");
		}
		if (B.size() == 0) {
			System.out.print("None");
		}
		System.out.println();
		for (int e : C) {
			System.out.print(e + " ");
		}
		if (C.size() == 0) {
			System.out.println("None");
		}

	}
}
