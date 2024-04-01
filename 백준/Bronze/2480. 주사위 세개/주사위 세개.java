import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        if (list.get(0).equals(list.get(1)) && list.get(0).equals(list.get(2))) {
            System.out.println(10000 + list.get(0) * 1000);
        } else if (list.get(0).equals(list.get(1))) {
            System.out.println(1000 + list.get(0) * 100);
        } else if (list.get(1).equals(list.get(2))) {
            System.out.println(1000 + list.get(1) * 100);
        } else {
            System.out.println(list.get(2) * 100);
        }

    }
}