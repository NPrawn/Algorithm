import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        long a,b;

        a = sc.nextLong();
        b = sc.nextLong();

        long tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b == a) {
            System.out.println("0");
            System.exit(0);
        }
        System.out.println(b - a - 1);
        for (long i = a + 1; i < b; i++) {
            System.out.print(i + " ");
        }
    }
}