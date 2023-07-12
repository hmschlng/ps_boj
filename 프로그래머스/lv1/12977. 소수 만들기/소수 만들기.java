import java.util.*;

class Solution {
    static int ans;
    static int[] res;
    public int solution(int[] nums) {
        ans = 0;
        res = new int[3];
        comb(0,0,nums);
        return ans;
    }
    
    public void comb(int n, int r, int[] nums) {
        if(n == 3) {
            int sum = Arrays.stream(res).sum();
            if(isPrime(sum)) {
                ans++;
            }
            return;
        }
        if(r >= nums.length) {
            return;
        }
        
        res[n] = nums[r];
        comb(n+1, r+1, nums);
        res[n] = 0;
        comb(n, r+1, nums);
    }
    
    public boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num) + 1; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}