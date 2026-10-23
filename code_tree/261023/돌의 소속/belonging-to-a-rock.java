import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, q;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<3; i++) {
            arr.add(new ArrayList<>());
            arr.get(i).add(0);
        }

        for (int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine()) - 1;
            for (int j=0; j<3; j++) {
                if (tmp == j) {
                    arr.get(j).add(arr.get(j).get(arr.get(j).size() - 1) + 1);
                } else {
                    arr.get(j).add(arr.get(j).get(arr.get(j).size() - 1));
                }
            }
        }
        
        for (int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            sb.append(arr.get(0).get(en) - arr.get(0).get(start-1));
            sb.append(" ");
            sb.append(arr.get(1).get(en) - arr.get(1).get(start-1));
            sb.append(" ");
            sb.append(arr.get(2).get(en) - arr.get(2).get(start-1));
            sb.append(" ");
            System.out.println(sb.toString());
        }
    }
}