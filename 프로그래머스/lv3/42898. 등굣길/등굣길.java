import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        long[][] dp = new long[n+1][m+1];
        
        dp[1][1] = 1;
        for(int i = 0; i < puddles.length; i++) {
            int[] p = puddles[i];
            dp[p[1]][p[0]] = -1;
        }
    
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(dp[i][j] == -1) continue;
                if(i == 1 && j == 1) continue;
                
                long fromUp = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
                long fromLeft = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
                
                dp[i][j] = (fromUp + fromLeft) % MOD;
            }
        }
        
        return (int) dp[n][m];
    }
}