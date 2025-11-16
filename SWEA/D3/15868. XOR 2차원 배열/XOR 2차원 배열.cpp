#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;
    vector<string> ans;
    ans.reserve(T);

    for (int tc = 0; tc < T; ++tc) {
        int n, m;
        cin >> n >> m;

        vector<vector<int>> grid(n, vector<int>(m));
        for (int i = 0; i < n; ++i) {
            string s;
            cin >> s; // line of 0/1 chars
            for (int j = 0; j < m; ++j) {
                grid[i][j] = s[j] - '0';
            }
        }

        bool ok = true;
        for (int i = 0; i < n && ok; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != (grid[i][0] ^ grid[0][j] ^ grid[0][0])) {
                    ok = false;
                    break;
                }
            }
        }

        ans.push_back(ok ? "yes" : "no");
    }

    for (int i = 0; i < T; ++i) {
        cout << "#" << (i + 1) << " " << ans[i];
        if (i + 1 < T) cout << '\n';
    }

    return 0;
}
