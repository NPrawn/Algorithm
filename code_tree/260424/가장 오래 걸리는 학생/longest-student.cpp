#include <iostream>
using namespace std;

const int INF = 0x3f3f3f3f;

struct Graph {
    int head[100005];
    int to[200005];
    int nxt[200005];
    int cost[200005];
    int cnt;

    void init(int n) {
        for(int i=0; i<=n; i++) {
            head[i] = -1;
        }

        cnt = 0;
    }

    void addEdge(int u, int v, int c) {
        to[cnt] = v;
        cost[cnt] = c;
        nxt[cnt] = head[u];
        head[u] = cnt;
        cnt++;
    }
};

struct MinHeap {
    int node[200005];
    int cost[200005];
    int size;

    void init() {
        size = 0;
        
    }

    int empty() {
        return size==0;
    }

    void push(int c, int v) {
        cost[++size] = c;
        node[size] = v;
        int idx = size;
        while (idx > 1) {
            int parent = idx / 2;
            if (cost[parent] <= cost[idx]) break;

            int tmp = cost[parent];
            cost[parent] = cost[idx];
            cost[idx] = tmp;

            tmp = node[parent];
            node[parent] = node[idx];
            node[idx] = tmp;

            idx = parent;
        }
    }

    void pop(int *outNode, int *outCost) {
        *outCost = cost[1];
        *outNode = node[1];
        node[1] = node[size];
        cost[1] = cost[size--];
        int idx = 1;
        while (1) {
            int left = idx * 2;
            int right = left + 1;
            int smallest = idx;

            if (left <= size && cost[left] < cost[smallest]) {
                smallest = left;
            }

            if (right <= size && cost[right] < cost[smallest]) {
                smallest = right;
            }

            if (smallest == idx) break;
            
            int tmp = cost[smallest];
            cost[smallest] = cost[idx];
            cost[idx] = tmp;

            tmp = node[smallest];
            node[smallest] = node[idx];
            node[idx] = tmp;

            idx = smallest;
        }

    }
};

Graph graph;
MinHeap heap;

int main() {
    int n, m;
    cin >> n >> m;
    graph.init(n);
    heap.init();

    for (int i=0; i<m; i++) {
        int u, v, c;
        cin >> u >> v >> c;
        graph.addEdge(u, v, c);
        graph.addEdge(v, u, c);
    }

    int dist[100005];
    for (int i=0; i<n; i++) {
        dist[i] = INF;
    }
    dist[n] = 0;
    heap.push(0, n);

    while (!heap.empty()) {
        int now, w;
        heap.pop(&now, &w);
        if (dist[now] != w) continue;
        
        for (int e=graph.head[now]; e!=-1; e=graph.nxt[e]) {
            int nxt = graph.to[e];
            int nw = graph.cost[e];
            if (dist[nxt] <= dist[now] + nw) continue;
            dist[nxt] = dist[now] + nw;
            heap.push(dist[nxt], nxt);
        }
    }   

    int ans = 0;
    for (int i=0; i<n; i++) {
        if (dist[i] == INF) continue;
        if (ans < dist[i]) {
            ans = dist[i];
        }
    }

    cout << ans;
    
    return 0;
}