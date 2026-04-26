#include <iostream>
using namespace std;

struct Graph {
    int head[100005];
    int to[200005];
    int nxt[200005];
    int cnt;

    void init(int n) {
        for (int i=0; i<=n; i++) {
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

Graph graph;

int queue[100005];
int order[100005];
int dp[100005][2];
int parent[100005];


int main() {
    int n;
    cin >> n;
    graph.init(n);
    
    for (int i=0; i<n-1; i++) {
        int a, b;
        cin >> a >> b;
        graph.addEdge(a, b);
        graph.addEdge(b, a);
    }

    int front = 0;
    int rear = 0;
    int orderCnt = 0;

    queue[rear++] = 1;
    parent[1] = -1;
    
    while (front < rear) {
        int cur = queue[front++];
        order[orderCnt++] = cur;

        for (int e=graph.head[cur]; e!=-1; e=graph.nxt[e]) {
            int nxt = graph.to[e];
            if (parent[cur] == nxt) continue;

            parent[nxt] = cur;
            queue[rear++] = nxt;
        }
    }

    for (int i=orderCnt-1; i >= 0; i--) {
        int cur = order[i];
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (int e=graph.head[cur]; e!=-1; e=graph.nxt[e]) {
            int child = graph.to[e];

            if (parent[child] != cur) continue;
            
            dp[cur][0] += dp[child][1];
            if (dp[child][0] < dp[child][1]) {
                dp[cur][1] += dp[child][0];
            } else {
                dp[cur][1] += dp[child][1];
            }
        }
    }

    if (dp[1][0] < dp[1][1]) {
        cout << dp[1][0];
    } else {
        cout << dp[1][1];
    }


    return 0;
}