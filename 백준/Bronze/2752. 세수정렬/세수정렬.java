import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max, min, mid;
        if (a < b && a < c) {
            min = a;
            if (b < c) {
                mid = b;
                max = c;
            } else {
                mid = c;
                max = b;
            }
        } else if (b < a && b < c) {
            min = b;
            if (a < c) {
                mid = a;
                max = c;
            } else {
                mid = c;
                max = a;
            }
        } else {
            min = c;
            if (a < b) {
                mid = a;
                max = b;
            } else {
                mid = b;
                max = a;
            }
        }
        System.out.println(min + " " + mid + " " + max);
    }
}