import java.io.*;

public class Main {
    static char board[];
    static int ans = 0, robot, box, flag;

    public static void main(String[] args) throws IOException {
        board = new char[10];
        String s = br.readLine();
        for (int i = 0; i < 10; i++) {
            board[i] = s.charAt(i);
            if (board[i] == '@') {
                robot = i;
            } else if (board[i] == '#') {
                box = i;
            } else if (board[i] == '!') {
                flag = i;
            }
        }
        if (robot < box && box < flag) {
            ans = (flag - box) + (box - robot - 1);
        } else if (robot > box && box > flag) {
            ans = (robot - box - 1) + (box - flag);
        } else {
            ans = -1;
        }
        bw.write(ans + "");
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
}