import java.util.*;

class Solution {
    static int[] damages;
    public int solution(int number, int limit, int power) {
        damages = new int[number+1];
        Arrays.fill(damages, 2);
        damages[1] = 1;
        init(number);
        int ans = 0;
        for(int i = 1; i <= number; i++) {
            if(damages[i] > limit) {
                ans += power;
            } else {
                ans += damages[i];
            }
        }
        
        return ans;
    }
    
    public void init(int number) {
        for(int i = 2; i <= number/2; i++) {
            for(int j = i; j <= number; j += i) {
                if(i != j) {
                    damages[j]++;
                }
            }
        }
    }
}