import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static char[][] tree = new char[26][2];

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(input.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			
			tree[a - 'A'][0] = b;
			tree[a - 'A'][1] = c;
		}
		
		pre('A');
		sb.append('\n');
		in('A');
		sb.append('\n');
		post('A');
		System.out.println(sb.toString());
	}
	
	public static void pre(char c) {
		sb.append(c);
		char l = tree[c-'A'][0];
		char r = tree[c-'A'][1];
		if(l != '.') pre(l);
		if(r != '.') pre(r);
	}
	
	public static void in(char c) {
		char l = tree[c-'A'][0];
		char r = tree[c-'A'][1];
		if(l != '.') in(l);
		sb.append(c);
		if(r != '.') in(r);
	}
	
	public static void post(char c) {
		char l = tree[c-'A'][0];
		char r = tree[c-'A'][1];
		if(l != '.') post(l);
		if(r != '.') post(r);
		sb.append(c);
	}
}
