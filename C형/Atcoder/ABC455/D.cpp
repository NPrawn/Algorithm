#include <iostream>

int n, q;
int ans[300005];
int prev[300005];
int next[300005];

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> q;

    for (int i=1; i<=n; i++) {
        prev[i] = 0;
        next[i] = 0;
    }

    while (q--) {
        int c, p;
        std::cin >> c >> p;

        int before = prev[c];

        if (before != 0) {
            next[before] = 0;
        }

        prev[c] = p;
        next[p] = c;
    }

    for (int i=1; i<=n; i++) {
        if (prev[i] != 0) {
            ans[i] = 0;
            continue;
        }

        int ct = 0;
        int cur = i;

        while (cur != 0) {
            ct++;
            cur = next[cur];
        }

        ans[i] = ct;
    }

    for (int i=1; i<=n; i++) {
        std::cout << ans[i] << " ";
    }

    return 0;
}