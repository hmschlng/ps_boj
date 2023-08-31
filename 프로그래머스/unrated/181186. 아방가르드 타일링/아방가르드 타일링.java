import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;
    public int solution(int n) {
        long[][] dp = new long[4][n+1];
        
        dp[0][0] = 1;
        dp[0][1] = 1;
        if(n >= 2) dp[0][2] = 3;
        
        long val = 0;
        for(int i = 3; i <= n; i++) {
            val = dp[0][i-1];
            val = sum(val, mul(dp[0][i-2], 2));
            val = sum(val, mul(dp[0][i-3], 5));
            
            if(i >= 4) dp[1][i] = sum(dp[0][i-4], dp[1][i-3]);
            if(i >= 5) dp[2][i] = sum(dp[0][i-5], dp[2][i-3]);
            if(i >= 6) dp[3][i] = sum(dp[0][i-6], dp[3][i-3]);
            
            val = sum(val, mul(dp[1][i], 2));
            val = sum(val, mul(dp[2][i], 2));
            val = sum(val, mul(dp[3][i], 4));
            
            dp[0][i] = val;
        }
        
        // for(long[] a : dp) System.out.println(Arrays.toString(a));
        
        return (int)dp[0][n];
    }
    
    public long mul(long a, long b) {
        return (a * b) % MOD;
    }
    
    public long sum(long a, long b) {
        return (a + b) % MOD;
    }
}