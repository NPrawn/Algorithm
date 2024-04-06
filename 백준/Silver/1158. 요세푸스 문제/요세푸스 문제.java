import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> linkedList = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            linkedList.add(i + 1);
        }
        int idx = k - 1;
        bw.write("<");
        while (!linkedList.isEmpty()) {
            bw.write(String.valueOf(linkedList.get(idx)));
            linkedList.remove(idx);
            idx--;
            idx += k;
            while (idx >= linkedList.size() && !linkedList.isEmpty()) {
                idx -= linkedList.size();
            }
            if (!linkedList.isEmpty()) {
                bw.write(", ");
            }
        }
        bw.write(">");
        br.close();
        bw.close();
    }
}