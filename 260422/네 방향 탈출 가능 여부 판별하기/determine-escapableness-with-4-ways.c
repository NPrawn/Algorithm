#include <stdio.h>

int main() {
    int n, m;
    scanf("%d %d", &n, &m);

    int board[n][m];
    int visited[n][m];

    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            scanf("%d", &board[i][j]);
            visited[i][j] = 0;
        }
    }

    if (board[0][0] == 0 || board[n-1][m-1] == 0) {
        printf("0\n");
        return 0;
    }

    int qx[n*m];
    int qy[n*m];
    int front = 0, rear = 0;

    int dx[4] = {-1,1,0,0};
    int dy[4] = {0,0,-1,1};

    qx[rear] = 0;
    qy[rear] = 0;
    rear++;
    visited[0][0] = 1;

    while (front < rear) {
        int x = qx[front];
        int y = qy[front];
        front++;

        if (x == n - 1 && y == m - 1) {
            printf("1\n");
            return 0;
        }

        for (int d=0; d<4;d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx <0 || nx >= n || ny< 0 || ny >= m) continue;
            if (board[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = 1;
            qx[rear] = nx;
            qy[rear] = ny;
            rear++;
        }
    }

    printf("0\n");
    return 0;
}