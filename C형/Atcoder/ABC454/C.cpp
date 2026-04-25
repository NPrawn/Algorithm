#include <iostream>

struct Graph {
    int head[300005];
    int to[300005];
    int nxt[300005];
    int cnt;

    void init(int n) {
        for (int i = 0; i <= n; i++) {
            head[i] = -1;
        }
        cnt = 0;
    }

    void addEdge(int u, int v) {
        to[cnt] = v;
        nxt[cnt] = head[u];
        head[u] = cnt;
        cnt++;
    }
};

int n, m;
Graph graph;

int queue[300005];
int front, rear;
int used[300005];

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> m;
    graph.init(n);
    for (int i = 0; i < m; i++) {
        int u, v;
        std::cin >> u >> v;

        graph.addEdge(u, v);
    }


    front = 0;
    rear = 0;
    queue[rear++] = 1;
    used[1] = 1;
    int ans = 1;

    while (front < rear) {
        int now = queue[front++];

        for (int e = graph.head[now]; e != -1; e = graph.nxt[e]) {
            int nxt = graph.to[e];
            if (used[nxt] != 0) continue;
            used[nxt]++;
            ans++;
            queue[rear++] = nxt;
        }
    }

    std::cout << ans;

    return 0;
}
