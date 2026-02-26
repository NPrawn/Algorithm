import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int n, k;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(input.readLine());
		k = Integer.parseInt(input.readLine());
		
		int l = 1;
		int r = 1000000000;
		
		while (l < r) {
			int mid = l + (r-l) / 2;
			if (check(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		
		System.out.println(l);
	}
	
	static boolean check(int t) {
		int ct = 0;
		for (int i=1; i<=n; i++) {
			ct += Math.min(n, t / i);
		}
		
		return ct >= k;
	}
}