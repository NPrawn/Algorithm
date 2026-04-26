#include <iostream>

int adj[10][10];

int main() {
    int v;
    int tc = 1;
    
    while (std::cin >> v) {
        if (v == 0) break;

        for (int i=0; i<10; i++) {
            for (int j=0;j<10;j++) {
                adj[i][j] = 0;
            }
        }

        for (int i=0; i<v-1; i++) {
            int a, b;
            std::cin >> a >> b;
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        int ans = 0;
        int limit = 1 << v;

        for (int mask = 1; mask < limit; mask++) {
            int vcnt = 0;
            int ecnt = 0;

            for (int i=0; i<v; i++) {
                if (mask & (1 << i)) vcnt++;
            }

            for (int i=0; i<v; i++) {
                if ((mask & (1 << i)) == 0) continue;
                for (int j=i+1; j<v; j++) {
                    if ((mask & (1 << j)) == 0) continue;
                    if (adj[i][j]) ecnt++;
                }
            }

            if (ecnt == vcnt - 1) ans++;
        }

        std::cout << "Case " << tc << ": " << ans << '\n';
        tc++;
    }
    return 0;
}