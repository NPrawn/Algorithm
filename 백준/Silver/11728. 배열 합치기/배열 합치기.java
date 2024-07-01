import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n + m];
        int idxA = 0;
        int idxB = 0;

        for (int i = 0; i < ans.length; i++) {
            if (idxA == n) ans[i] = b[idxB++];
            else if (idxB == m) ans[i] = a[idxA++];
            else if (a[idxA] < b[idxB]) ans[i] = a[idxA++];
            else if (b[idxB] < a[idxA]) ans[i] = b[idxB++];
            else ans[i] = a[idxA++];
        }

        for (int e : ans) {
            sb.append(e + " ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}