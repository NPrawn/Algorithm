import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int a = sc.nextInt();
            list.add(a);
            sum += a;
        }
        Collections.sort(list);
        sum -= 100;
        int n = 0, m = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (n != 0) {
                break;
            }
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == sum) {
                    n = i;
                    m = j;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == n || i == m) {
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}