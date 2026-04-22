#include <stdio.h>

int heap[100005];
int heap_size = 0;

void push(int x) {
    int idx = ++heap_size;
    heap[idx] = x;

    while (idx > 1) {
        int parent = idx / 2;
        if (heap[parent] <= heap[idx]) break;

        int temp = heap[parent];
        heap[parent] = heap[idx];
        heap[idx] = temp;

        idx = parent;
    }
}

int pop() {
    if (heap_size == 0) return 0;
    int res = heap[1];
    heap[1] = heap[heap_size--];

    int idx = 1;
    while (1) {
        int left = idx * 2;
        int right = left + 1;
        int smallest = idx;

        if (left <= heap_size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right <= heap_size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest == idx) break;

        int temp = heap[idx];
        heap[idx] = heap[smallest];
        heap[smallest] = temp;

        idx = smallest;
    }


    return res;
}

int main() {
    int n;
    scanf("%d", &n);

    while (n--) {
        int x;
        scanf("%d", &x);
        if (x==0) {
            printf("%d\n", pop());
        } else {
            push(x);
        }
    }

    return 0;
}