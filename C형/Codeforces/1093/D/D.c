#include <stdio.h>

static int buf[2005];
static int bad;

int ask(int k, int *s) {
    printf("? %d", k);
    for (int i = 0; i < k; i++) {
        printf(" %d", s[i]);
    }
    printf("\n");
    fflush(stdout);

    int ans;
    if (scanf("%d", &ans) != 1) {
        bad = 1;
        return -1;
    }
    if (ans == -1) {
        bad = 1;
        return -1;
    }
    return ans;
}

int has_all_three(int k, int *s) {
    int ans = ask(k, s);
    if (bad) return 0;
    return ((k - ans) & 1);
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d", &n);

        int N = 2 * n + 1;

        int l, r, mid;
        int x, y, z;

        l = 1;
        r = N;
        while (l < r) {
            mid = (l + r) >> 1;

            for (int i = 1; i <= mid; i++) {
                buf[i - 1] = i;
            }

            if (has_all_three(mid, buf)) {
                r = mid;
            } else {
                l = mid + 1;
            }

            if (bad) return 0;
        }
        z = l;

        l = 1;
        r = N;
        while (l < r) {
            mid = (l + r + 1) >> 1;

            int k = 0;
            for (int i = mid; i <= N; i++) {
                buf[k++] = i;
            }

            if (has_all_three(k, buf)) {
                l = mid;
            } else {
                r = mid - 1;
            }

            if (bad) return 0;
        }
        x = l;

        l = x + 1;
        r = z - 1;
        while (l < r) {
            mid = (l + r) >> 1;

            int k = 0;
            buf[k++] = x;
            for (int i = x + 1; i <= mid; i++) {
                buf[k++] = i;
            }
            buf[k++] = z;

            if (has_all_three(k, buf)) {
                r = mid;
            } else {
                l = mid + 1;
            }

            if (bad) return 0;
        }
        y = l;

        printf("! %d %d %d\n", x, y, z);
        fflush(stdout);
    }

    return 0;
}