#include <stdio.h>

int main() {
    int T;
    scanf("%d", &T);
    while (T--) {
        int n, m;
        scanf("%d %d", &n, &m);
        int arr[n + 1];
        for (int i = 1; i <= n; i++) {
            scanf("%d", &arr[i]);
        }
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if ((arr[i] + i) % m == 0) {
                ans = 0;
            }
        }

        if (ans) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
    }
}