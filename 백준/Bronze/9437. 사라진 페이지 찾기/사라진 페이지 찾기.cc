#include <cstdio>

int main() {
    int n, p;

    while (1) {
        scanf("%d", &n);
        if (n == 0) break;
        scanf("%d", &p);
        
        int k1 = (p-1) / 2;
        int k2 = (n - p) / 2;

        int k = k1 < k2 ? k1 : k2;
        
        int a = 2 * k + 1;
        int b = 2 * k + 2;
        int c = n - 2*k - 1;
        int d = n- 2*k;

        int first = 1;
        if (a!=p) {
            if (!first) printf(" ");
            printf("%d", a);
            first = 0;
        }

        if (b != p) {
            if (!first) printf(" ");
            printf("%d", b);
            first = 0;
        }

        if (c != p) {
            if (!first) printf(" ");
            printf("%d", c);
            first = 0;
        }

        if (d != p) {
            if (!first) printf(" ");
            printf("%d", d);
            first = 0;
        }

        printf("\n");
    }


    return 0;
}