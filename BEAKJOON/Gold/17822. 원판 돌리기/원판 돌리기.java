import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m, t, ans;
    static int[][] arr;
    static int num;
    static int total = 0, ct = 0;

    static int[] rotate(int r, int d, int k) {
        int[] newArr = new int[m];
        if (d == 0) {
            for (int i = 0; i < m; i++) {
                newArr[i] = arr[r][(i + m - k) % m];
            }
        } else {
            for (int i = 0; i < m; i++) {
                newArr[i] = arr[r][(i + k) % m];
            }
        }

        return newArr;
    }

    static boolean[][] Zero(int[][] arr) {
        boolean[][] zero = new boolean[n + 1][m];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) continue;
                ct++;
                total += arr[i][j];

                if (arr[i][j] == arr[i][(j + 1) % m]) {
                    zero[i][j] = zero[i][(j + 1) % m] = true;
                    num++;
                }

                if (i < n && arr[i][j] == arr[i + 1][j]) {
                    zero[i][j] = zero[i + 1][j] = true;
                    num++;
                }
            }
        }
        return zero;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int remain = n * m;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int r = x; r <= n; r += x) {
                arr[r] = rotate(r, d, k);
            }

            if (remain > 0) {
                num = 0;
                total = 0;
                ct = 0;
                boolean[][] zero = Zero(arr);

                if (num == 0) {
                    double avg = (double) total / (double) ct;
                    for (int r = 1; r <= n; r++) {
                        for (int c = 0; c < m; c++) {
                            if (arr[r][c] == 0) continue;
                            if ((double) arr[r][c] < avg) arr[r][c]++;
                            else if ((double) arr[r][c] > avg) arr[r][c]--;
                        }
                    }
                } else {
                    for (int r = 1; r <= n; r++) {
                        for (int c = 0; c < m; c++) {
                            if (zero[r][c]) arr[r][c] = 0;
                        }
                    }
                }
            }
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 0; c < m; c++) {
                ans += arr[r][c];
            }
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.close();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
}