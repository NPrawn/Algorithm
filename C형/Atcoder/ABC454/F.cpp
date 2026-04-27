#include <iostream>
using namespace std;

const int MAXN = 200005;

int T;
int N;
long long M;
long long A[MAXN];
long long diffArr[MAXN];
long long tempArr[MAXN];

void mergeSort(int l, int r) {
    if (l >= r) return;

    int mid = (l + r) / 2;

    mergeSort(l, mid);
    mergeSort(mid + 1, r);

    int i = l;
    int j = mid + 1;
    int k = l;

    while (i <= mid && j <= r) {
        if (diffArr[i] >= diffArr[j]) {
            tempArr[k++] = diffArr[i++];
        } else {
            tempArr[k++] = diffArr[j++];
        }
    }

    while (i <= mid) {
        tempArr[k++] = diffArr[i++];
    }

    while (j <= r) {
        tempArr[k++] = diffArr[j++];
    }


    for (int x = l; x <= r; x++) {
        diffArr[x] = tempArr[x];
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> T;
    while (T--) {
        cin >> N >> M;

        for (int i = 1; i <= N; i++) {
            cin >> A[i];
        }

        int h = N / 2;

        long long prev = 0;
        long long sum = 0;
        int cnt = 0;

        for (int i = 1; i <= h; i++) {
            int j = N + 1 - i;
            long long cur = (A[j] - A[i] + M) % M;
            long long d = (cur - prev + M) % M;

            diffArr[cnt++] = d;
            sum += d;

            prev = cur;
        }

        long long last = (0 - prev + M) % M;
        diffArr[cnt++] = last;
        sum += last;

        long long K = sum / M;

        if (cnt > 0) {
            mergeSort(0, cnt - 1);
        }

        long long largestSum = 0;

        for (int i = 0; i < K; i++) {
            largestSum += diffArr[i];
        }

        long long answer = K * M - largestSum;

        cout << answer << '\n';
    }

    return 0;
}
