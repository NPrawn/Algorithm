#include <iostream>

int ans[200005];

int solution(int n) {
    int k = 0;
    int ct = n / 2;

    if (ct % 2 == 0) std::cout << n << '\n';
    else std::cout << n-1 << '\n';

    for (int i=n-1; i>1; i-=2) {
        std::cout << i << ' ' << i-1 << '\n';
        k++;
    }

    for (int i=1; i<ct; i+=2) {
        std::cout << 1 << ' ' << 1 << '\n';
        k++;
    }

    if (ct % 2 == 0) {
        for (int j=k; j<n-2; j++) {
            std::cout << 0 << ' ' << 0 << '\n';
        }
        std::cout << n << ' ' << 0 << '\n';
        return n;
    }
    for (int j=k; j<n-2; j++) {
            std::cout << 1 << ' ' << 0 << '\n';
        }
    std::cout << n << ' ' << 1 << '\n';
    return n-1;
}

int main() {
    int n;
    std::cin >> n;
    solution(n);
    return 0;
}