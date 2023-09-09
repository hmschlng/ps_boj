import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        long[][] dp = new long[money.length + 1][n + 1];
        Arrays.sort(money);
        Arrays.stream(dp).forEach(x -> x[0] = 1);
        for(int i = 1; i <= n; i++) {
            if(i % money[0] == 0) dp[1][i] = 1;
        }
        
        for(int i = 2; i <= money.length; i++) {
            int cost = money[i-1];
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= cost) dp[i][j] = (dp[i][j] + dp[i][j - cost]) % MOD;
                // if(j % cost == 0) dp[j]++;
            }
            
        }
        // for(long[] a : dp) System.out.println(Arrays.toString(a));
        
        
        return (int)dp[money.length][n];
    }
}