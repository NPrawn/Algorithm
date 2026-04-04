import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		char[] A = input.readLine().trim().toCharArray();
		char[] B = input.readLine().trim().toCharArray();
		int a = A.length, b = B.length;

		int[][] dp = new int[a+1][b+1];

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				if (A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		int i=a, j=b;
		
		while (i > 0 && j > 0) {
			if (A[i-1] == B[j-1]) {
				sb.append(A[i-1]);
				i--;
				j--;
			} else {
				if (dp[i-1][j] >= dp[i][j-1]) i--;
				else j--;
			}
		}
		
		System.out.println(dp[a][b]);
		System.out.println(sb.reverse());
	}
}