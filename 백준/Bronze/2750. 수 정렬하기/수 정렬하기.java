import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, n);
        for (int e : arr) {
            sb.append(e + "\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    static void merge_sort(int st, int en) {
        if (st + 1 == en) return;
        int mid = (st + en) / 2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }

    static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lidx = st;
        int ridx = mid;
        for (int i = st; i < en; i++) {
            if (ridx == en) tmp[i] = arr[lidx++];
            else if (lidx == mid) tmp[i] = arr[ridx++];
            else if (arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        for (int i = st; i < en; i++) arr[i] = tmp[i];
    }
}