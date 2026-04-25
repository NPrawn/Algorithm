#include <stdio.h>
#define ll long long

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        ll p, q;
        scanf("%lld %lld", &p, &q);

        ll S = p + (q << 1);
        ll N = (S << 1) + 1;

        ll ansN = -1, ansM = -1;

        for (ll d=1; d*d <= N; d++) {
            if (N % d != 0) continue;

            ll a = d;
            ll b = N / d;

            if (a == 1) continue;

            ll n = (a - 1) / 2;
            ll m = (b - 1) / 2;

            ll diff = n - m;
            if (diff < 0) diff = -diff;

            if (n >= 1 && m >= 1 && diff <= p) {
                ansN = n;
                ansM = m;
                break;
            }
        }

        if (ansN==-1) {
            printf("-1\n");
        } else {
            printf("%lld %lld\n", ansN, ansM);
        }
    }

    return 0;
}