import java.util.*;

class Solution {
    
    public String[] solution(String[][] plans) {
        int idx = 0;
        int n = plans.length;
        String[] ans = new String[n];
        HashMap<Integer, String> map = new HashMap<>();
        for (String[] s : plans) {
            map.put(idx++, s[0]);
        }
        
        int[][] grid = new int[n][3];
        for (int i=0; i<n;i++){
            grid[i][0] = i;
            String[] e = plans[i][1].split(":");
            int h = Integer.parseInt(e[0]);
            int m = Integer.parseInt(e[1]);
            grid[i][1] = h*60 + m;
            grid[i][2] = Integer.parseInt(plans[i][2]);
        }
        Arrays.sort(grid, (a, b) -> Integer.compare(a[1], b[1]));
        idx = 0;
        int time = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i=0; i<n-1; i++) {
            int remain = grid[i][2] - grid[i+1][1] + grid[i][1];
            if (remain <= 0) {
                ans[idx++] = map.get(grid[i][0]);
                while (!q.isEmpty() && remain < 0) {
                    int[] tmp = q.pollFirst();
                    tmp[1] += remain;
                    if (tmp[1] <= 0) {
                        remain = tmp[1];
                        ans[idx++] = map.get(tmp[0]);
                    } else {
                        remain = 0;
                        q.addFirst(new int[]{tmp[0], tmp[1]});
                    }
                }
            } else {
                q.addFirst(new int[] {grid[i][0], grid[i][2] - grid[i+1][1] + grid[i][1]});
            }
        }
        
        ans[idx++] = map.get(grid[n-1][0]);
        while (!q.isEmpty()) {
            ans[idx++] = map.get(q.pollFirst()[0]);
        }
        return ans;
    }
}