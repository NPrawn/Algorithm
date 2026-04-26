#include <iostream>
using namespace std;

int n;
int parent[100005];
int childCnt[100005];
int q[100005];
int dp[100005];

int main() {
    cin >> n;

    for (int i=2; i<=n; i++) {
        int t, a, p;
        cin >> t >> a >> p;
        if (t==0) a=-a;
        dp[i] = a;
        parent[i] = p;
        childCnt[p]++;
    }

    int front = 0;
    int rear = 0;

    for (int i=2; i<=n; i++) {
        if (childCnt[i] == 0) {
            q[rear++] = i;
        }
    }

    while (front < rear) {
        int cur = q[front++];
        int p = parent[cur];
        if (dp[cur] > 0) {
            dp[p] += dp[cur];
        }
        childCnt[p]--;
        if (p != 1 && childCnt[p] == 0) q[rear++] = p;
    }

    cout << dp[1];
    return 0;
}