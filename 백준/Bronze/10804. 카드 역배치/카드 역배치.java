import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list1.clear();
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                list1.add(list.get(j));
            }
            int n = b - a;
            for (int j = 0; j <= n; j++) {
                list.set(b, list1.get(j));
                b--;
            }
        }

        for (int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}