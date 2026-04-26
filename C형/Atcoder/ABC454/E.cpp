#include <iostream>
using namespace std;

const int MAXL = 1000005;

int T;
int n, a, b;

char pre[MAXL];
char sufRev[MAXL];
int preLen, sufLen;

void addPre(char c) {
    pre[preLen++] = c;
}

void addSufRev(char c) {
    sufRev[sufLen++] = c;
}

void addPreRepeat(char c, int cnt) {
    for (int i = 0; i < cnt; i++) {
        addPre(c);
    }
}

void addSufRevRepeat(char c, int cnt) {
    for (int i = 0; i < cnt; i++) {
        addSufRev(c);
    }
}

void addRowToPre(int W) {
    addPreRepeat('R', W - 1);
    addPre('D');
    addPreRepeat('L', W - 1);
    addPre('D');
}

void addRowToSuffix(int W) {
    addSufRevRepeat('R', W - 1);
    addSufRev('D');
    addSufRevRepeat('L', W - 1);
    addSufRev('D');
}

void addColToPre() {
    addPre('D');
    addPre('R');
    addPre('U');
    addPre('R');
}

void addColToSuffix() {
    addSufRev('D');
    addSufRev('R');
    addSufRev('U');
    addSufRev('R');
}

int main() {
    cin >> T;

    while (T--) {
        cin >> n >> a >> b;

        if (n % 2 == 1 || (a + b) % 2 == 0) {
            cout << "No\n";
            continue;
        }

        preLen = 0;
        sufLen = 0;

        int h = n;
        int w = n;

        while (h > 2) {
            if (a > 2) {
                addRowToPre(w);
                a -= 2;
                h -= 2;
            } else {
                addRowToSuffix(w);
                h -= 2;
            }
        }

        while (w > 2) {
            if (b > 2) {
                addColToPre();
                b -= 2;
                w -= 2;
            } else {
                addColToSuffix();
                w -= 2;
            }
        }

        if (a == 1 && b == 2) {
            addPre('D');
            addPre('R');
        } else {
            addPre('R');
            addPre('D');
        }

        cout << "Yes\n";

        for (int i = 0; i < preLen; i++) {
            cout << pre[i];
        }

        for (int i = sufLen - 1; i >= 0; i--) {
            cout << sufRev[i];
        }

        cout << '\n';
    }

    return 0;
}
