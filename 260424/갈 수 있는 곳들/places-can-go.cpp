#include <iostream>

int n, k;
int grid[105][105];

int ans = 0;
int queueX[10005];
int queueY[10005];
int left = 0;
int right = 0;
int vis[10005] {0};

int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

int main() {
    std::cin >> n >> k;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n;j++) {
            std::cin >> grid[i][j];
        }
    }


    for (int i=0; i<k; i++) {
        int a,b;
        std::cin >> a >> b;
        a--;
        b--;
        queueX[right] = a;
        queueY[right++] = b;
        vis[a*n+b] = 1;
        ans++;
    }

    while(left < right) {
        int x = queueX[left];
        int y = queueY[left++];

        for (int d=0; d<4; d++) {
            int nx = x+dx[d];
            int ny = y+dy[d];
            if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if (vis[nx*n+ny]) continue;
            if (grid[nx][ny] == 1) continue;
            vis[nx*n+ny] = 1;
            ans++;
            queueX[right] = nx;
            queueY[right++] = ny;
        }       
    }
    
    std::cout << ans;
    return 0;
}