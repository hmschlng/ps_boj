class Solution {
    public long solution(int n) {
        
        long[] memo = new long[2000 + 1];
        
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i = 3; i <= 2000; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 1234567;
        }
        
        return memo[n];
    }

}

