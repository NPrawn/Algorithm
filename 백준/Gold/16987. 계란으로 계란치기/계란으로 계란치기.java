import java.io.*;
import java.util.*;

public class Main {
    static int n, ans = 0, cnt = 0;
    static Egg[] arr;

    static class Egg {
        int s, w;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

    public static void func(int cur) {
        if (cur == n) {
            ans = Math.max(ans, cnt);
            return;
        }
        Egg now = arr[cur];
        if (now.s <= 0 || cnt == n - 1) {
            func(cur + 1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i == cur) continue;
            if (arr[i].s <= 0) continue;
            Egg next = arr[i];
            now.s -= next.w;
            next.s -= now.w;
            if (now.s <= 0) cnt++;
            if (next.s <= 0) cnt++;
            func(cur + 1);
            if (now.s <= 0) cnt--;
            if (next.s <= 0) cnt--;
            now.s += next.w;
            next.s += now.w;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Egg(s, w);

        }

        func(0);

        bw.write(ans + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}