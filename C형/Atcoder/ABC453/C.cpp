#include <iostream>

int main() {
    int n;
    std::cin >> n;

    long long arr[25];
    for (int i=0; i<n; i++) {
        std::cin >> arr[i];
        arr[i] *= 10;
    }

    int total = 1 << n;
    int ans = 0;
    for (int mask = 0; mask < total; mask++) {
        long long now = 5;
        int ct = 0;
        for (int i=0; i<n; i++) {
            long long nxt = now;
            if (((mask >> i) & 1) != 0) {
                nxt += arr[i];
            } else {
                nxt -= arr[i];
            }
            if (now < 0 && nxt > 0) ct++;
            if (now > 0 && nxt < 0) ct++;

            now = nxt;
        }

        if (ans < ct) {
            ans = ct;
        }
    }

    std::cout << ans;
    return 0;
}