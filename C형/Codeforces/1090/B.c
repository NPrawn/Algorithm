#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int max = 0x80000000;
        int ans = 0;
        for (int i=0; i<7; i++) {
            int x;
            scanf("%d", &x);

            if (max < x) {
                max = x;
            }

            ans -= x;
        }

        ans += max * 2;
        printf("%d\n", ans);
    }

    return 0;
}