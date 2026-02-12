import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] arr;
	static int n;
	static int k;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(input.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];

		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(input.readLine());
		int l = 1;
		int r = Integer.MAX_VALUE;
		
		
		while (l<r) {
			int mid = l + (r-l+1)/2;
			if (check(mid)) {
				l = mid;
			} else{
				r = mid-1;
			}
		}
		
		System.out.println(l);
	}
	
	static boolean check(int mid) {
		int ct = 0;
		for (int a : arr) {
			ct += a/mid;
		}
		return k <= ct;
		
	}
}
