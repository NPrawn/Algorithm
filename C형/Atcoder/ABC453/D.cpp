#include <iostream>

const int MAXH = 1000;
const int MAXW = 1000;
const int MAXSTATE = 4000005;

int H, W;
char grid[MAXH][MAXW + 5];

int qArr[MAXSTATE];
int frontIdx, rearIdx;

int parentState[MAXSTATE];
char parentMove[MAXSTATE];

int sx, sy, gx, gy;

int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,-1,1};
char dirChar[4] = {'U', 'D', 'L', 'R'};

char answer[MAXSTATE];

int getId(int x, int y, int dir) {
    return ((x*W + y) << 2) | dir;
}

int getX(int id) {
    return (id >> 2) / W;
}

int getY(int id) {
    return (id >> 2) % W;
}

int getDir(int id) {
    return id & 3;
}

int canMoveDir(char cell, int prevDir, int nextDir) {
    if (cell == '.' || cell == 'S' || cell == 'G') {
        return 1;
    }

    if (cell == 'o') {
        return prevDir == nextDir;
    }

    if (cell == 'x') {
        return prevDir != nextDir;
    }

    return 0;
}

int main() {
    std::cin >> H >> W;

    for (int i=0; i<H; i++) {
        std::cin >> grid[i];

        for (int j=0; j<W; j++) {
            if (grid[i][j] == 'S') {
                sx = i;
                sy = j;
            }

            if (grid[i][j] == 'G') {
                gx = i;
                gy = j;
            }
        }
    }

    int totalState = H*W*4;

    for (int i=0; i<totalState; i++) {
        parentState[i] = -2;
    }

    frontIdx = 0;
    rearIdx = 0;

    for (int d=0; d<4; d++) {
        int startId = getId(sx, sy, d);
        parentState[startId] = -1;
        qArr[rearIdx++] = startId;
    }

    int goalState = -1;

    while (frontIdx < rearIdx) {
        int curId = qArr[frontIdx++];

        int x = getX(curId);
        int y = getY(curId);
        int prevDir = getDir(curId);

        if (x == gx && y == gy) {
            goalState = curId;
            break;
        }

        char cell = grid[x][y];

        for (int nd = 0; nd<4; nd++) {
            if (!canMoveDir(cell, prevDir, nd)) continue;

            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
            if (grid[nx][ny] == '#') continue;

            int nextId = getId(nx, ny, nd);

            if (parentState[nextId] != -2) continue;

            parentState[nextId] = curId;
            parentMove[nextId] = dirChar[nd];
            qArr[rearIdx++] = nextId;
        }
    }

    if (goalState == -1) {
        std::cout << "No\n";
        return 0;
    }

    int len = 0;
    int cur = goalState;

    while (parentState[cur] != -1) {
        answer[len++] = parentMove[cur];
        cur = parentState[cur];
    }

    std::cout << "Yes\n";

    for (int i=len -1; i>=0; i--) {
        std::cout << answer[i];
    }

    std::cout << "\n";


    return 0;
}