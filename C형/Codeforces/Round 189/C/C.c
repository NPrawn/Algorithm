#include <stdio.h>

#define MAXN 200005
#define INF 1000000000

char s[MAXN], t[MAXN];
int dp[MAXN];

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d", &n);
        scanf("%s", s);
        scanf("%s", t);

        dp[0] = 0;
        for (int i=1; i<=n;i++) {
            int v = (s[i-1] != t[i-1]);
            dp[i] = dp[i-1] + v;

            if (i >= 2) {
                int h = (s[i-2] != s[i-1]) + (t[i-2] != t[i-1]);
                if (dp[i] > dp[i-2] + h) {
                    dp[i] = dp[i-2] + h;
                }
            }
        }

        printf("%d\n", dp[n]);
    }

    return 0;
}