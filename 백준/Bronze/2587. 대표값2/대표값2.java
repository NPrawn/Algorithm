import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int avg = 0;
        for (int i = 0; i < 5; i++) {
            int a = sc.nextInt();
            list.add(a);
            avg += a;
        }
        Collections.sort(list);
        System.out.println(avg / 5);
        System.out.println(list.get(2));

    }
}