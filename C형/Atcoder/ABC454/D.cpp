#include <iostream>
using namespace std;

const int MAXL = 2000005;

int T;

char A[MAXL];
char B[MAXL];
char stk1[MAXL];
char stk2[MAXL];

void normalize(char s[], char stk[], int &top) {
    top = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        stk[top++] = s[i];

        while (top >= 4) {
            if (stk[top - 4] == '(' &&
                stk[top - 3] == 'x' &&
                stk[top - 2] == 'x' &&
                stk[top - 1] == ')') {

                top -= 4;
                stk[top++] = 'x';
                stk[top++] = 'x';
                } else {
                    break;
                }
        }
    }

    stk[top] = '\0';
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> T;

    while (T--) {
        cin >> A;
        cin >> B;

        int top1 = 0;
        int top2 = 0;

        normalize(A, stk1, top1);
        normalize(B, stk2, top2);

        int same = 1;

        if (top1 != top2) {
            same = 0;
        } else {
            for (int i = 0; i < top1; i++) {
                if (stk1[i] != stk2[i]) {
                    same = 0;
                    break;
                }
            }
        }

        cout << (same ? "Yes\n" : "No\n");
    }

    return 0;
}