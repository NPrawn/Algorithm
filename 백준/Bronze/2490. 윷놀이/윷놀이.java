import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int sum;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 4; j++) {
                list.add(sc.nextInt());
                sum += list.get(j);
            }
            switch(sum) {
                case 0:
                    System.out.println("D");
                    break;
                case 1:
                    System.out.println("C");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("A");
                    break;
                case 4:
                    System.out.println("E");
                    break;
            }
            list.clear();
        }
    }
}