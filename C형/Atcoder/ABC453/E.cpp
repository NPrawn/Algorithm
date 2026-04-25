#include <iostream>
using namespace std;

const int MAXN = 200005;
const int MOD = 998244353;

int N;
int L[MAXN], R[MAXN];

int diffA[MAXN];
int diffB[MAXN];
int diffBoth[MAXN];

int aCnt[MAXN];
int bCnt[MAXN];
int bothCnt[MAXN];

long long fact[MAXN];
long long invFact[MAXN];

long long modPow(long long a, long long e) {
    long long res = 1;

    while (e > 0) {
        if (e & 1) res = res * a % MOD;
        a = a * a % MOD;
        e >>= 1;
    }

    return res;
}

long long comb(int n, int r) {
    if (r < 0 || r > n) return 0;
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
}

void addRange(int diff[], int l, int r) {
    if (l < 1) l = 1;
    if (r > N - 1) r = N - 1;
    if (l > r) return;

    diff[l]++;
    diff[r + 1]--;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N;

    fact[0] = 1;
    for (int i = 1; i <= N; i++) {
        fact[i] = fact[i - 1] * i % MOD;
    }

    invFact[N] = modPow(fact[N], MOD - 2);
    for (int i = N - 1; i >= 0; i--) {
        invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    for (int i = 1; i <= N; i++) {
        cin >> L[i] >> R[i];

        int aL = L[i];
        int aR = R[i];

        int bL = N - R[i];
        int bR = N - L[i];

        addRange(diffA, aL, aR);
        addRange(diffB, bL, bR);

        int bothL = aL > bL ? aL : bL;
        int bothR = aR < bR ? aR : bR;

        addRange(diffBoth, bothL, bothR);
    }

    for (int k = 1; k <= N - 1; k++) {
        aCnt[k] = aCnt[k - 1] + diffA[k];
        bCnt[k] = bCnt[k - 1] + diffB[k];
        bothCnt[k] = bothCnt[k - 1] + diffBoth[k];
    }

    long long answer = 0;

    for (int k = 1; k <= N - 1; k++) {
        int canAtLeastOne = aCnt[k] + bCnt[k] - bothCnt[k];

        if (canAtLeastOne != N) continue;

        int forcedA = aCnt[k] - bothCnt[k];
        int need = k - forcedA;

        if (need < 0 || need > bothCnt[k]) continue;

        answer += comb(bothCnt[k], need);
        answer %= MOD;
    }

    cout << answer << '\n';

    return 0;
}