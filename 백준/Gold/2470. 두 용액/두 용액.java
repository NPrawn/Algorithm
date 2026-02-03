import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(input.readLine());
		arr = new int[n];
		st = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		int best = Integer.MAX_VALUE;
		int a = 0, b = 0;

		for (int i = 0; i < n; i++) {
			int x = arr[i];
			int idx = lowerBound(-x);

			if (idx < n && idx != i) {
				int y = arr[idx];
				int sum = x + y;
				int abs = Math.abs(sum);
				if (abs < best) {
					best = abs;
					a = x;
					b = y;
				}
			}

			if (idx - 1 >= 0 && idx - 1 != i) {
				int y = arr[idx - 1];
				int sum = x + y;
				int abs = Math.abs(sum);
				if (abs < best) {
					best = abs;
					a = x;
					b = y;
				}
			}
		}

		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		System.out.println(a + " " + b);

	}

	public static int lowerBound(int target) {
		int lo = 0;
		int hi = n;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (arr[mid] >= target)
				hi = mid;
			else
				lo = mid + 1;
		}

		return lo;
	}

	public static int upperBound(int target) {
		int lo = 0;
		int hi = n;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > target)
				hi = mid;
			else
				lo = mid + 1;
		}

		return lo;
	}
}
