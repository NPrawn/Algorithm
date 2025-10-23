import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, l;
    static Node[] road;
    static Queue<Integer> truck;

    static class Node {
        int weight, time;

        Node(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        road = new Node[w];
        truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Arrays.fill(road, new Node(0, 0));

        int t = 0;
        int now = 0;
        while (!truck.isEmpty() || now != 0) {

            for (int i = 0; i < w; i++) {
                if (road[i].weight == 0) continue;
                road[i].time--;
                if (road[i].time == 0) {
                    now -= road[i].weight;
                    road[i].weight = 0;
                }
            }

            if (!truck.isEmpty() && now + truck.peek() <= w) {
                for (int i = 0; i < w; i++) {
                    if (road[i].weight == 0) {
                        road[i] = new Node((int) truck.poll(), l);
                        now += road[i].weight;
                        break;
                    }
                }
            }

            t++;
        }

        bw.write(t + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}