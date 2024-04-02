import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        long sumY = 0;
        long sumM = 0;
        long n = sc.nextInt();
        for (long i = 0; i < n; i++) {
            long a = sc.nextInt();
            sumY += (a / 30 + 1) * 10;
            sumM += (a / 60 + 1) * 15;
        }
        if (sumY < sumM) {
            System.out.println("Y " + sumY);
        } else if (sumM < sumY) {
            System.out.println("M " + sumM);
        } else {
            System.out.println("Y M " + sumY);
        }
    }
}