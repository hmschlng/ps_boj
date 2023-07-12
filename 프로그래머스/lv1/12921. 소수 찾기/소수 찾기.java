class Solution {
    public int solution(int n) {
        int[] primes = new int[n+1];
        for(int i = 2; i <= n; i++) {
            if(primes[i] < 0) continue;
            primes[i] = i;
            for(int j = i*2; j <= n; j+=i) {
                if(primes[j] < 0) continue;
                primes[j] = -1;
            }
        }
        
        int ans = 0;
        for(int i = 2; i <= n; i++) {
            if(primes[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
}