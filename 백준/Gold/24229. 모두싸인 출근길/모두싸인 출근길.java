import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		int[][] arr = new int[n][2];
		for (int i=0; i<n;i++) {
			st = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
		}
		Arrays.sort(arr, (a,b) -> {
			if (a[0] == b[0])
				return Integer.compare(a[1], b[1]);
			return Integer.compare(a[0], b[0]);
		});
		
		ArrayList<int[]> lst = new ArrayList<>();
		int s = arr[0][0];
		int e = arr[0][1];
		
		for (int i=1; i<n; i++) {
			if (arr[i][0] <= e) {
				e = Math.max(e, arr[i][1]);
			} else {
				lst.add(new int[] {s,e});
				s = arr[i][0];
				e = arr[i][1];
			}
		}
		
		lst.add(new int[] {s,e});
		int max = 0;
		int ans = 0;
		
		for (int i = 0; i < lst.size(); i++) {
			int ns = lst.get(i)[0];
			int ne = lst.get(i)[1];

			if (ns > max) break;

			ans = ne;
			max = Math.max(max, ne + (ne - ns));
		}

		System.out.println(ans);
	}
}
