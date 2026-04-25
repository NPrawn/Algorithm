#include <iostream>

const int MAXN = 100005;
const int MAXM = 100005;
const long long INF = 4000000000000000000LL;

struct Graph {
    int head[MAXN];
    int to[MAXM];
    int w[MAXM];
    int nxt[MAXM];
    int edgeCnt;

    void init(int n) {
        for (int i=0; i<=n; i++) {
            head[i] = -1;
        }
        edgeCnt = 0;
    }

    void addEdge(int u, int v, int cost) {
        to[edgeCnt] = v;
        w[edgeCnt] = cost;
        nxt[edgeCnt] = head[u];
        head[u] = edgeCnt;
        edgeCnt++;
    }
};

struct MinHeap {
    int node[MAXM];
    long long dist[MAXM];
    int size;

    void clear() {
        size = 0;
    }

    bool empty() {
        return size == 0;
    }

    void push(int newNode, long long newDist) {
        size++;
        node[size] = newNode;
        dist[size] = newDist;

        int idx = size;
        while (idx > 1) {
            int parent = idx / 2;
            if (dist[parent] <= dist[idx]) break;

            long long tempDist = dist[parent];
            dist[parent] = dist[idx];
            dist[idx] = tempDist;

            int tempNode = node[parent];
            dist[parent] = node[idx];
            node[idx] = tempNode;

            idx = parent;
        }
    }

    void pop(int &outNode, long long &outDist) {
        outNode = node[1];
        outDist = dist[1];

        node[1] = node[size];
        dist[1] = dist[size];
        size--;

        int idx = 1;
        while (1) {
            int left = idx * 2;
            int right = left+1;
            int smallest = idx;

            if (left <= size && dist[left] < dist[smallest]) {
                smallest = left;
            }

            if (right <= size && dist[right] < dist[smallest])
                smallest = right;

            if (smallest == idx) break;

            long long tempDist = dist[idx];
            dist[idx] = dist[smallest];
            dist[smallest] = tempDist;

            int tempNode = node[idx];
            node[idx] = node[smallest];
            node[smallest] = tempNode;

            idx = smallest;
        }
    }
};

int main() {

}