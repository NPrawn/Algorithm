import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static long n;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            pq.add(Long.parseLong(st.nextToken()));

            if (pq.size() < 3) {
                System.out.println(-1);
                continue;
            } 

            long num1 = pq.poll();
            long num2 = pq.poll();
            long num3 = pq.poll();
            
            System.out.println(num1 * num2 * num3);
            pq.add(num1);
            pq.add(num2);
            pq.add(num3);
        }
    }
}