import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		int[] arr = new int[n+1];
		arr[n] = 1;
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(n);
		while(!q.isEmpty()) {
			int now = q.pollFirst();
			int nxt = 0;
			if (now%3==0) {
				nxt = now/3;
				if (arr[nxt] == 0) {
					arr[nxt] = arr[now]+1;
					q.add(nxt);
				}
			}
			if (now%2==0) {
				nxt = now/2;
				if (arr[nxt]==0) {
					arr[nxt] = arr[now]+1;
					q.add(nxt);
				}
			}
			nxt = now - 1;
			if (nxt >= 0) {
				if (arr[nxt]==0) {
					arr[nxt] = arr[now]+1;
					q.add(nxt);
				}
			}
		}
		
		System.out.println(arr[1]-1);
	}
}