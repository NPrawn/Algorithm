#include <iostream>

const int MAXN = 100005;
const long long MOD = 998244353;

int n, q;

struct SegTree {
    long long sum[MAXN * 4];
    long long sq[MAXN * 4];
    long long lazy[MAXN * 4];

    void apply(int node, int l, int r, long long v) {
        long long len = r - l + 1;
        v %= MOD;

        long long oldSum = sum[node];

        sq[node] = (sq[node] + 2LL * v % MOD * oldSum % MOD + v * v % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + v * len % MOD) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0) return;
        if (l == r) {
            lazy[node] = 0;
            return;
        }

        int mid = (l + r) / 2;

        apply(node * 2, l, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, r, lazy[node]);

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr, long long v) {
        if (qr < l || r < ql) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, v);
            return;
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr, v);
        update(node * 2 + 1, mid + 1, r, ql, qr, v);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    long long querySum(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;

        if (ql <= l && r <= qr) {
            return sum[node];
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        long long left = querySum(node * 2, l, mid, ql, qr);
        long long right = querySum(node * 2 + 1, mid + 1, r, ql, qr);

        return (left + right) % MOD;
    }

    long long querySq(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;

        if (ql <= l && r <= qr) {
            return sq[node];
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        long long left = querySq(node * 2, l, mid, ql, qr);
        long long right = querySq(node * 2 + 1, mid + 1, r, ql, qr);

        return (left + right) % MOD;
    }
};

SegTree seg;

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> q;

    while (q--) {
        int l, r;
        long long a;

        std::cin >> l >> r >> a;

        seg.update(1, 1, n, l, r, a);

        long long s = seg.querySum(1, 1, n, l, r);
        long long ss = seg.querySq(1, 1, n, l, r);

        long long ans = (s*s % MOD - ss + MOD) % MOD;
        ans *= 499122177;
        ans %= MOD;

        std::cout << ans << "\n";
    }

    return 0;
}
