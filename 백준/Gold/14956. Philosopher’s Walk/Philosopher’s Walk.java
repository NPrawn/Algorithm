import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Node philo(int side, int walk) {
        if (side == 2) {
            switch (walk) {
                case 1:
                    return new Node(1, 1);
                case 2:
                    return new Node(1, 2);
                case 3:
                    return new Node(2, 2);
                case 4:
                    return new Node(2, 1);
            }
        }
        int half = side / 2;
        int section = half * half;
        if (walk <= section) {
            Node rv = philo(half, walk);
            return new Node(rv.y, rv.x);
        } else if (walk <= 2 * section) {
            Node rv = philo(half, walk - section);
            return new Node(rv.x, rv.y + half);
        } else if (walk <= 3 * section) {
            Node rv = philo(half, walk - 2 * section);
            return new Node(half + rv.x, half + rv.y);
        } else {
            Node rv = philo(half, walk - 3 * section);
            return new Node(2 * half - rv.y + 1, half - rv.x + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int side, walk;

        StringTokenizer st = new StringTokenizer(br.readLine());
        side = Integer.parseInt(st.nextToken());
        walk = Integer.parseInt(st.nextToken());

        Node ans = philo(side, walk);
        bw.write(ans.x + " " + ans.y);

        br.close();
        bw.close();
    }
}