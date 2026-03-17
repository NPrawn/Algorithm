import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(input.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int l = 1;
		int ans = 1;
		int cur = arr[0];
		int ct = 1;
		for (int i=1; i<n; i++) {
			if (cur <= arr[i]) {
				l+=1;
				ans = Math.max(ans, l);
			} else {
				l=1;
				ct += 1;
			}
			cur = arr[i];
		}
		
		System.out.println(ct + " " + ans);
	}
}
