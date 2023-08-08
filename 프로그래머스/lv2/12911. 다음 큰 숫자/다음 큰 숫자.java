import java.util.*;

class Solution {
    static int ccnt = 0;
    public int solution(int n) {
        int limit = Integer.toBinaryString(n).length() + 1;
        int og = countOne(n, limit);
        
        for(int i = n + 1; i <= n*2; i++) {
            ccnt++;
            int cnt = countOne(i, limit);
            if(og == cnt) {
                return i;
            }
        }
        return 0;
    }
    
    public int countOne(int num, int limit) {
        int cnt = 0;
        for(int i = 0; i <= limit; i++) {
            if((num & 1 << i) != 0) cnt++;            
        }
        return cnt;
    }
}