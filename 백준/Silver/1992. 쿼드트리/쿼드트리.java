import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[][] grid;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(input.readLine());
		grid = new char[n][n];
		for (int i=0; i<n;i++) {
			String str = input.readLine();
			for (int j=0;j<n;j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		System.out.println(f(0, 0, n - 1, n - 1));
	}

	static String f(int sx, int sy, int ex, int ey) {
		char a = grid[sx][sy];
		boolean check = true;
		for (int x = sx; x <= ex; x++) {
			for (int y = sy; y <= ey; y++) {
				if (a != grid[x][y])
					check = false;
			}
		}

		if (check)
			return String.valueOf(a);
		int midx = (sx + ex) / 2;
		int midy = (sy + ey) / 2;

		return "("
        + f(sx, sy, midx, midy)
        + f(sx, midy + 1, midx, ey)
        + f(midx + 1, sy, ex, midy)
        + f(midx + 1, midy + 1, ex, ey)
        + ")";
	}
}
