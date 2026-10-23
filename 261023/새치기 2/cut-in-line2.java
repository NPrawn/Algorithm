
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, Node> map = new HashMap<>();

    static class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
        }
    }

    static void connect(Node a, Node b) {
        a.next = b;
        b.prev = a;
    }

    static void remove(Node a) {
        connect(a.prev, a.next);
    }

    static void insertBefore(Node a, Node b) {
        Node prev = b.prev;
        connect(prev, a);
        connect(a, b);
    }

    static void moveRange(Node a, Node b, Node c) {
        // a부터 b까지 기존 줄에서 분리
        connect(a.prev, b.next);

        // 분리한 구간을 c 앞에 연결
        Node prev = c.prev;
        connect(prev, a);
        connect(b, c);
    }

    static String next() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(next());
        int m = Integer.parseInt(next());
        int q = Integer.parseInt(next());

        Node[] head = new Node[m];
        Node[] tail = new Node[m];

        for (int i = 0; i < m; i++) {
            head[i] = new Node("");
            tail[i] = new Node("");
            connect(head[i], tail[i]);
        }

        int x = n / m;

        for (int i = 0; i < n; i++) {
            String name = next();
            Node node = new Node(name);
            map.put(name, node);

            int row = i / x;
            insertBefore(node, tail[row]);
        }

        for (int i = 0; i < q; i++) {
            int cmd = Integer.parseInt(next());

            if (cmd == 1) {
                Node a = map.get(next());
                Node b = map.get(next());

                if (a == b) continue;

                remove(a);
                insertBefore(a, b);

            } else if (cmd == 2) {
                Node a = map.get(next());
                remove(a);

            } else if (cmd == 3) {
                Node a = map.get(next());
                Node b = map.get(next());
                Node c = map.get(next());

                moveRange(a, b, c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            Node cur = head[i].next;

            while (cur != tail[i]) {
                sb.append(cur.name);

                if (cur.next != tail[i]) {
                    sb.append(" ");
                }

                cur = cur.next;
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
