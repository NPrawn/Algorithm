#include <iostream>
using namespace std;

struct Graph {
    int head[100005];
    int to[200005];
    int nxt[200005];
    int edgeCnt;

    void init(int n) {
        for (int i=0; i<=n; i++) {
            head[i] = -1;
        }
        
        edgeCnt=0;
    }

    void addEdge(int u, int v) {
        to[edgeCnt] = v;
        nxt[edgeCnt] = head[u];
        head[u] = edgeCnt;
        edgeCnt++;
    }
};

Graph graph;

int queue[100005];
int order[100005];
int parent[100005];
int dp[100005];
int n;

int main() {
    cin >> n;
    graph.init(n);
    for (int i=2; i<=n; i++) {
        int t, a, p;
        cin >> t >> a >> p;
        if (t==0) a=-a;
        dp[i] = a;
        parent[i] = p;
        graph.addEdge(i, p);
        graph.addEdge(p, i);
    }

    int front = 0;
    int rear = 0;
    queue[rear++] = 1;
    parent[1] = 0;
    int orderCnt = 0;

    while (front < rear) {
        int cur = queue[front++];
        order[orderCnt++] = cur;

        for (int e=graph.head[cur]; e!=-1; e=graph.nxt[e]) {
            int nxt = graph.to[e];
            
            if (parent[cur] == nxt) continue;
            queue[rear++] = nxt;
        }
    }

    for (int i=orderCnt-1; i>=0; i--) {
        int cur = order[i];
        if (dp[cur] <= 0) continue;
        dp[parent[cur]] += dp[cur];
    }

    cout << dp[1];
    return 0;
}