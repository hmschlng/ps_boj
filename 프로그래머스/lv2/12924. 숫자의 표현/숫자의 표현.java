import java.util.*;

class Solution {
    public int solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 1;
        int cnt = 1;
        int left = 1;
        int right = 2;
        int val = 3;
        while(left < right && right <= (n/2 + 1)) {
            if(val < n) {
                right++;
                val += right;
            }
            else if(val > n) {
                val -= left;
                left++;
            } else {
                cnt++;
                val -= (left++);
            }
        }
        return cnt;
    }
}