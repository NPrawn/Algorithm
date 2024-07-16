import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int n;
    static String[] serial;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        serial = new String[n];

        for (int i = 0; i < n; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    int sum1 = 0;
                    int sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    if (sum1 == sum2) {
                        return o1.compareTo(o2);
                    } else {
                        return sum1 - sum2;
                    }
                }
            }
        });

        for (String s : serial) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}