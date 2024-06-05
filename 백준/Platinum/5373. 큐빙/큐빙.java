import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int t, n;
    static char[][] front = new char[3][3];
    static char[][] back = new char[3][3];
    static char[][] up = new char[3][3];
    static char[][] down = new char[3][3];
    static char[][] left = new char[3][3];
    static char[][] right = new char[3][3];

    static void rotateL(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = left[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    left[i][j] = copy[2 - j][i];
                }
            }


            for (int i = 0; i < 3; i++) {
                tmp[i] = front[i][0];
                front[i][0] = up[i][0];
                up[i][0] = back[2 - i][2];
                back[2 - i][2] = down[i][0];
                down[i][0] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    left[i][j] = copy[j][2 - i];
                }
            }


            for (int i = 0; i < 3; i++) {
                tmp[i] = front[i][0];
                front[i][0] = down[i][0];
                down[i][0] = back[2 - i][2];
                back[2 - i][2] = up[i][0];
                up[i][0] = tmp[i];
            }
        }
    }

    static void rotateR(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = right[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    right[i][j] = copy[2 - j][i];
                }
            }


            for (int i = 0; i < 3; i++) {
                tmp[i] = front[i][2];
                front[i][2] = down[i][2];
                down[i][2] = back[2 - i][0];
                back[2 - i][0] = up[i][2];
                up[i][2] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    right[i][j] = copy[j][2 - i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = front[i][2];
                front[i][2] = up[i][2];
                up[i][2] = back[2 - i][0];
                back[2 - i][0] = down[i][2];
                down[i][2] = tmp[i];
            }
        }
    }

    static void rotateU(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = up[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    up[i][j] = copy[2 - j][i];
                }
            }


            for (int i = 0; i < 3; i++) {
                tmp[i] = front[0][i];
                front[0][i] = right[0][i];
                right[0][i] = back[0][i];
                back[0][i] = left[0][i];
                left[0][i] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    up[i][j] = copy[j][2 - i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = front[0][i];
                front[0][i] = left[0][i];
                left[0][i] = back[0][i];
                back[0][i] = right[0][i];
                right[0][i] = tmp[i];
            }
        }
    }

    static void rotateD(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = down[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    down[i][j] = copy[2 - j][i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = front[2][i];
                front[2][i] = left[2][i];
                left[2][i] = back[2][i];
                back[2][i] = right[2][i];
                right[2][i] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    down[i][j] = copy[j][2 - i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = front[2][i];
                front[2][i] = right[2][i];
                right[2][i] = back[2][i];
                back[2][i] = left[2][i];
                left[2][i] = tmp[i];
            }
        }
    }

    static void rotateF(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = front[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    front[i][j] = copy[2 - j][i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = up[2][i];
                up[2][i] = left[2 - i][2];
                left[2 - i][2] = down[0][2 - i];
                down[0][2 - i] = right[i][0];
                right[i][0] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    front[i][j] = copy[j][2 - i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = up[2][i];
                up[2][i] = right[i][0];
                right[i][0] = down[0][2 - i];
                down[0][2 - i] = left[2 - i][2];
                left[2 - i][2] = tmp[i];
            }
        }
    }

    static void rotateB(char dir) {
        char[][] copy = new char[3][3];
        char[] tmp = new char[3];
        for (int i = 0; i < 3; i++) {
            copy[i] = back[i].clone();
        }
        if (dir == '+') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    back[i][j] = copy[2 - j][i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = up[0][i];
                up[0][i] = right[i][2];
                right[i][2] = down[2][2 - i];
                down[2][2 - i] = left[2 - i][0];
                left[2 - i][0] = tmp[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    back[i][j] = copy[j][2 - i];
                }
            }

            for (int i = 0; i < 3; i++) {
                tmp[i] = up[0][i];
                up[0][i] = left[2 - i][0];
                left[2 - i][0] = down[2][2 - i];
                down[2][2 - i] = right[i][2];
                right[i][2] = tmp[i];
            }
        }
    }

    static void rotate(char cmd, char dir) {
        if (cmd == 'L') {
            rotateL(dir);
        } else if (cmd == 'R') {
            rotateR(dir);
        } else if (cmd == 'U') {
            rotateU(dir);
        } else if (cmd == 'D') {
            rotateD(dir);
        } else if (cmd == 'F') {
            rotateF(dir);
        } else if (cmd == 'B') {
            rotateB(dir);
        }
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    up[i][j] = 'w';
                    down[i][j] = 'y';
                    front[i][j] = 'r';
                    back[i][j] = 'o';
                    left[i][j] = 'g';
                    right[i][j] = 'b';
                }
            }
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char[] cmd = st.nextToken().toCharArray();
                rotate(cmd[0], cmd[1]);

            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(up[i][j]);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}