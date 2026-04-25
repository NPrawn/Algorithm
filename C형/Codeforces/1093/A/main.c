#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);
    while (T--) {
        int n, m;
        scanf("%d", &n);
        scanf("%d", &m);

        int prev;
        scanf("%d", &prev);
        int run = 1;
        int ok = 1;

        for (int i = 1; i < n; i++) {
            int x;
            scanf("%d", &x);
            if (x == prev) {
                run++;
                if (run >= m) ok = 0;
            } else {
                prev = x;
                run = 1;
            }
        }

        if (ok) {
            puts("YES");
        } else {
            puts("NO");
        }
    }
    return 0;
}
