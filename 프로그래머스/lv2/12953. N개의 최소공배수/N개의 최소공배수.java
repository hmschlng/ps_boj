import java.util.*;

class Solution {
    static List<Integer> primes;
    static boolean[] isPrime;
    public int solution(int[] arr) {
        init();
        int[] times = new int[100+1];
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            for(int j = 0; j < primes.size() && primes.get(j) <= num; j++) {
                int prime = primes.get(j);
                
                if(num % prime == 0) {
                    int cnt = 0;
                    while(num % prime == 0) {
                        cnt++;
                        num /= prime;
                    }
                    times[prime] = Math.max(times[prime], cnt);
                }
            }
        }
        
        int ans = 1;
        for(int i = 0; i < times.length; i++) {
            if(times[i] != 0) {
                ans *= Math.pow(i,times[i]);
            }
        }
        return ans;
    }
    
    public void init() {
        primes = new ArrayList<>();
        isPrime = new boolean[100+1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= 100; i++) {
            if(!isPrime[i]) continue;
            isPrime[i] = true;
            primes.add(i);
            for(int j = i*2; j <= 100; j+=i) {
                isPrime[j] = false;
            }
        }
    }
}