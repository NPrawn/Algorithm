import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static User[] users;

    static class User {
        int age;
        String name;

        User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        users = new User[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users[i] = new User(age, name);
        }
        Arrays.sort(users, Comparator.comparingInt(c -> c.age));

        for (User e : users) {
            sb.append(e.age);
            sb.append(" ");
            sb.append((e.name));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}