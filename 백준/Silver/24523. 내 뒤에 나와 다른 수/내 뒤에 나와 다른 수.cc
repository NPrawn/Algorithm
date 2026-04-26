#include <iostream>

int main() {
    int n;
    
    std::cin >> n;

    int arr[n];
    for (int i=0; i<n;i++) {
        std::cin >> arr[i];
    }

    int ans[n];
    int l = 0, r = 1;

    for (int i=0; i<n; i++) {
        ans[i] = -1;
    }
    
    while (l < r) {
        while (r < n && arr[l] == arr[r]){
            r++;
        }
        if (r == n) break;
        while (l < r) {
            ans[l++] = r+1;
        }
        l = r;
        r = r+1;
    }

    for (int i=0; i<n; i++) {
        std::cout << ans[i] << ' ';
    }
}