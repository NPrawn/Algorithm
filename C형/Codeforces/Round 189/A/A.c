#include <stdio.h>
#define ll long long

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        ll x, y;
        scanf("%lld %lld", &x, &y);

        ll z = x << 1;
        if (z < y) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
    }

    return 0;
}