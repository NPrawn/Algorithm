import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(input.readLine());

			List<String> origin = new LinkedList<>();
			st = new StringTokenizer(input.readLine());
			for (int i = 0; i < n; i++)
				origin.add(st.nextToken());

			int k = Integer.parseInt(input.readLine());
			st = new StringTokenizer(input.readLine());
			while (st.hasMoreTokens()) {
				String cmd = st.nextToken();
				if (cmd.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						String s = st.nextToken();
						origin.add(x, s);
						x+=1;
					}
				} else if (cmd.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int i=0; i<y; i++) {
						origin.remove(x);
					}
				}
			}
			
			sb.append("#").append(t).append(" ");
			for (int i=0; i<10;i++) {
				sb.append(origin.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
}