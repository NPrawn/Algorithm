#include <iostream>

int main() {
    int n,m;
    std::cin >> n >> m;

    int cnt[105] = {0};
    int kind = 0;
    int unique = 1;

    for (int i=0; i<n; i++) {
        int f;
        std::cin >> f;

        if (cnt[f] == 0) {
            kind++;
        } else {
            unique = 0;
        }

        cnt[f]++;
    }

    std::cout << (unique ? "Yes\n" : "No\n");
    std::cout << (kind == m ? "Yes\n" : "No\n");

    return 0;
}