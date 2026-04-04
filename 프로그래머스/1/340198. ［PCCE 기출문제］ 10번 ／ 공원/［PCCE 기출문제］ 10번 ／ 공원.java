import java.util.*;

class Solution {
    int n;
    int m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        n = park.length;
        m = park[0].length;

        Arrays.sort(mats);
        for (int l = 0, r = mats.length - 1; l < r; l++, r--) {
            int tmp = mats[l];
            mats[l] = mats[r];
            mats[r] = tmp;
        }
        for (int k : mats) {
            for (int x =0; x<n;x++) {
                for (int y=0; y<m;y++){
                    if (!park[x][y].equals("-1")) continue;
                    if (check(x,y,k, park)){
                        answer = k;
                        return answer;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean check(int sx, int sy, int k, String[][] park){
        for (int x=sx; x<sx+k; x++){
            if (x >= n) return false;
            for (int y=sy; y<sy+k; y++){
                if (y >= m) return false;
                if (!park[x][y].equals("-1")) return false;
            }
        }
        
        return true;
    }
}