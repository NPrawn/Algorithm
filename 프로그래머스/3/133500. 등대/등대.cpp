#include <string>
#include <vector>

using namespace std;

struct Graph{
    int head[100005];
    int to[200005];
    int nxt[200005];
    int edgeCnt;
    
    void init(int n) {
        for (int i=0; i<=n; i++) {
            head[i] = -1;
        }
        
        edgeCnt = 0;
    }
    
    void addEdge(int u, int v){
        to[edgeCnt] = v;
        nxt[edgeCnt] = head[u];
        head[u] = edgeCnt;
        edgeCnt++;
    }
};

Graph graph;

int parentArr[100005];
int orderArr[100005];
int queueArr[100005];
int dp[100005][2];

int solution(int n, vector<vector<int>> lighthouse) {
    graph.init(n);
    
    for (int i=0; i<lighthouse.size(); i++) {
        int a = lighthouse[i][0];
        int b = lighthouse[i][1];
        
        graph.addEdge(a, b);
        graph.addEdge(b, a);
    }
    
    int left = 0;
    int right = 0;
    int orderCnt = 0;
    
    queueArr[right++] = 1;
    parentArr[1] = -1;
    
    while (left < right) {
        int cur = queueArr[left++];
        orderArr[orderCnt++] = cur;
        
        for (int e=graph.head[cur]; e!=-1; e=graph.nxt[e]) {
            int nxt = graph.to[e];
            if (nxt == parentArr[cur]) continue;
            
            parentArr[nxt] = cur;
            queueArr[right++] = nxt;
        }
    }
    
    for (int i=orderCnt-1; i>=0; i--) {
        int cur = orderArr[i];
        
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        
        for (int e = graph.head[cur]; e!=-1; e=graph.nxt[e]){
            int child = graph.to[e];
            
            if (parentArr[child] != cur) continue;
            
            dp[cur][0] += dp[child][1];
            
            if (dp[child][0] < dp[child][1]) {
                dp[cur][1] += dp[child][0];
            } else {
                dp[cur][1] += dp[child][1];
            }
        }
    }
    
    if (dp[1][0] < dp[1][1]) return dp[1][0];
    return dp[1][1];
}