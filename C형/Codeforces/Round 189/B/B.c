#include <stdio.h>

char s[200005];

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        scanf("%s", s);

        int bad = 0;
        for (int i=0; s[i+1] != '\0'; i++) {
            if (s[i] == s[i+1]) bad++;
        }

        if (bad <= 2) printf("YES\n");
        else printf("NO\n");
    }
}