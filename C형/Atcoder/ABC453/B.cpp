#include <iostream>

int abs(int x) {
    if (x < 0) {
        return -x;
    }
    return x;
}

int main() {
    int n, x;
    std::cin >> n >> x;

    int prev = 0;
    std::cin >> prev;
    std:: cout << 0 << " " << prev << "\n";
    for (int i=1; i<=n; i++) {
        int k;
        std::cin >> k;
        if (abs(k-prev) >= x) {
            std::cout << i << " " << k << "\n";
            prev=k;
        }
    }

    return 0;
}