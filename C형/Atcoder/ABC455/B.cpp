#include <iostream>
using namespace std;

int n, m;
char grid[15][15];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> grid[i];
    }

    int ans = 0;

    for (int x1 = 0; x1 < n; x1++) {
        for (int y1 = 0; y1 < m; y1++) {
            for (int x2 = x1; x2 < n; x2++) {
                for (int y2 = y1; y2 < m; y2++) {
                    int ok = 1;

                    for (int i = x1; i <= x2; i++) {
                        for (int j = y1; j <= y2; j++) {
                            int ni = x1 + x2 - i;
                            int nj = y1 + y2 - j;

                            if (grid[i][j] != grid[ni][nj]) {
                                ok = 0;
                            }
                        }
                    }

                    if (ok) ans++;
                }
            }
        }
    }

    cout << ans;
    return 0;
}
