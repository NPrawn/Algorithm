#include <iostream>

int main() {
    int n;
    char s[55];

    std::cin >> n;
    std::cin >> s;

    int ck = 1;
    for (int i=0; i<n; i++) {
        if (ck && s[i] == 'o') continue;
        ck = 0;
        std::cout << s[i];
    }

    return 0;
}