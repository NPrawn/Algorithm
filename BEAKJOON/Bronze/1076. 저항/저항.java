import java.io.*;

public class Main {
    public static void main(String[] arg) throws IOException {
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            String s = br.readLine();
            switch (s) {
                case "black" -> arr[i] = 0;
                case "brown" -> arr[i] = 1;
                case "red" -> arr[i] = 2;
                case "orange" -> arr[i] = 3;
                case "yellow" -> arr[i] = 4;
                case "green" -> arr[i] = 5;
                case "blue" -> arr[i] = 6;
                case "violet" -> arr[i] = 7;
                case "grey" -> arr[i] = 8;
                case "white" -> arr[i] = 9;
            }
        }
        long ans = arr[0] * 10 + arr[1];
        for (int i = 0; i < arr[2]; i++) {
            ans *= 10;
        }

        System.out.println(ans);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}