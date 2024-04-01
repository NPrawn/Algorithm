import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int a = sc.nextInt();
            if (a % 2 == 1) {
                list.add(a);
                sum += a;
            }
        }
        Collections.sort(list);
        if (sum == 0) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(list.get(0));
        }

    }
}