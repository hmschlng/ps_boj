import java.util.*;

class Solution {
    static int ans;
    static int[] res;
    public int solution(int[] number) {
        ans = 0;
        res = new int[3];
        comb(0, 0, number);
        return ans;
    }
    
    public void comb(int n, int r, int[] number) { 
        if(3 == r) {
            int sum = Arrays.stream(res).sum();
            if(sum == 0) {
                ans++;
            }
            return;
        }
        if(n >= number.length) return;
        
        res[r] = number[n];
        comb(n+1, r+1, number);
        res[r] = 0;
        comb(n+1, r, number);
    }
}