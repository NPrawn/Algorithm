import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean isDigit(char c) { return '0' <= c && c <= '9'; }

	static long parseNumber(char[] s, int[] idx) {
		long v = 0;
		int n = s.length;
		while (idx[0] < n && isDigit(s[idx[0]])) {
			v = v * 10 + (s[idx[0]] - '0');
			idx[0]++;
		}
		return v;
	}

	static String parseAtom(char[] s, int[] idx) {
		StringBuilder a = new StringBuilder();
		a.append(s[idx[0]++]); // uppercase
		int n = s.length;
		int lower = 0;
		while (idx[0] < n && lower < 2) {
			char c = s[idx[0]];
			if ('a' <= c && c <= 'z') {
				a.append(c);
				idx[0]++;
				lower++;
			} else break;
		}
		return a.toString();
	}

	static void add(HashMap<String, Long> m, String k, long v) {
		m.put(k, m.getOrDefault(k, 0L) + v);
	}

	static void merge(HashMap<String, Long> a, HashMap<String, Long> b) {
		for (Map.Entry<String, Long> e : b.entrySet()) {
			String k = e.getKey();
			long v = e.getValue();
			a.put(k, a.getOrDefault(k, 0L) + v);
		}
	}

	static void multiply(HashMap<String, Long> m, long mul) {
		if (mul == 1) return;
		for (Map.Entry<String, Long> e : m.entrySet()) e.setValue(e.getValue() * mul);
	}

	public static void main(String[] args) throws Exception {
		String line;
		while ((line = input.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) break;

			char[] s = line.toCharArray();
			int n = s.length;
			int[] idx = {0};

			ArrayDeque<HashMap<String, Long>> st = new ArrayDeque<>();
			st.push(new HashMap<>());

			while (idx[0] < n) {
				char c = s[idx[0]];

				if (c == '(') {
					idx[0]++;
					st.push(new HashMap<>());
				} else if (c == ')') {
					idx[0]++;
					long mul = (idx[0] < n && isDigit(s[idx[0]])) ? parseNumber(s, idx) : 1;
					HashMap<String, Long> inner = st.pop();
					multiply(inner, mul);
					merge(st.peek(), inner);
				} else {
					String atom = parseAtom(s, idx);
					long cnt = (idx[0] < n && isDigit(s[idx[0]])) ? parseNumber(s, idx) : 1;
					add(st.peek(), atom, cnt);
				}
			}

			TreeMap<String, Long> sorted = new TreeMap<>(st.pop());
			boolean first = true;
			for (Map.Entry<String, Long> e : sorted.entrySet()) {
				if (!first) sb.append('+');
				first = false;
				long cnt = e.getValue();
				if (cnt != 1) sb.append(cnt);
				sb.append(e.getKey());
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
}