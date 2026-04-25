#include <iostream>
using namespace std;

const int HASH_SIZE = 1 << 20;

struct HashMap {
    int key[HASH_SIZE];
    long long value[HASH_SIZE];
    int used[HASH_SIZE];

    int getHash(int x) {
        unsigned int h = (unsigned int) x;
        h ^= h >> 16;
        h *= 0x7feb352d;
        h ^= h >> 15;
        h *= 0x846ca68b;
        h ^= h >> 16;
        return h & (HASH_SIZE - 1);
    }

    void add(int k, long long v) {
        int idx = getHash(k);

        while (used[idx] && key[idx] != k) {
            idx++;
            if (idx == HASH_SIZE) idx = 0;
        }

        if (!used[idx]) {
            used[idx] = 1;
            key[idx] = k;
            value[idx] = 0;
        }

        value[idx] += v;
    }
};

struct MinHeap {
    long long heap[300005];
    int size;

    void init() {
        size = 0;
    }

    void push (long long x) {
        heap[++size] = x;

        int idx = size;

        while (idx > 1) {
            int p = idx / 2;
            if (heap[p] <= heap[idx]) break;

            long tmp = heap[p];
            heap[p] = heap[idx];
            heap[idx] = tmp;

            idx = p;
        }
    }

    void pop() {
        heap[1] = heap[size--];

        int idx = 1;

        while (1) {
            int left = idx * 2;
            int right = left + 1;
            int smallest = idx;

            if (left <= size && heap[left] < heap[smallest])
                smallest = left;
            if (right <= size && heap[right] < heap[smallest])
                smallest = right;

            if (smallest == idx) break;

            long tmp = heap[smallest];
            heap[smallest] = heap[idx];
            heap[idx] = tmp;

            idx = smallest;
        }
    }

    long long top() {
        return heap[1];
    }
};

int n, k;
int arr[300005];
HashMap mp;
MinHeap heap;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> k;

    long long total = 0;

    for (int i=0; i<n; i++) {
        int x;
        cin >> x;

        total += x;
        mp.add(x, x);
    }

    heap.init();

    for (int i=0; i<HASH_SIZE; i++) {
        if (!mp.used[i]) continue;
        long long groupSum = mp.value[i];

        heap.push(-groupSum);
    }

    while (k-- && heap.size > 0) {
        total += heap.top();
        heap.pop();
    }

    cout << total;

    return 0;
}