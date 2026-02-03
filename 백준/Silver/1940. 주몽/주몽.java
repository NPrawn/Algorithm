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
		int m = Integer.parseInt(input.readLine());
		arr = new int[n];
		st = new StringTokenizer(input.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int ans = 0;
		
		for (int i=0;i<n;i++) {
			if (m - arr[i] < 0) continue;
			int idx = find(m - arr[i]);
			if (idx == i) continue;
			if (idx == -1) continue;
			ans++;
		}
		
		System.out.println(ans/2);
	}
	
	public static int find(int target) {
		int l = 0;
		int r = n-1;
		
		while (l<=r) {
			int mid = (l+r) / 2;
			if (arr[mid] == target) return mid;
			else if(arr[mid] < target) l = mid + 1;
			else r = mid - 1;
		}
		return -1;
	}
}
