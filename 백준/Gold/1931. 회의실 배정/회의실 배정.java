import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static class pair implements Comparable<pair> {
        int start;
        int end;

        @Override
        public int compareTo(pair other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        pair[] s = new pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = new pair();
            s[i].start = Integer.parseInt(st.nextToken());
            s[i].end = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);

        int t = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (t > s[i].start) continue;
            ans++;
            t = s[i].end;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }
}