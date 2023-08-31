import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        long[] asc = new long[len];
        long[] desc = new long[len];
        
        for(int i = 0, pul = 1; i < len; i++, pul *= -1) {
            asc[i] = sequence[i] * pul;
            desc[i] = sequence[i] * -pul;
        }
        
        long[][] dp = new long[2][len]; // 0:asc, 1:desc
        
        dp[0][0] = asc[0];
        dp[1][0] = desc[0];
        
        long ans = Math.max(dp[0][0], dp[1][0]);
        for(int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i-1] + asc[i], asc[i]);
            dp[1][i] = Math.max(dp[1][i-1] + desc[i], desc[i]);
    
            ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
        }
        
        return ans;
    }
}