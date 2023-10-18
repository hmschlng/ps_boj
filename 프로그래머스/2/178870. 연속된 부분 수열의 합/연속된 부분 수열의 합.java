import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] S = sequence;
        int[] ans = {};

        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = S[left];
        while(left <= right && right < S.length && left < S.length) {
            if(sum < k) {
                right++;
                if(right < S.length) sum += S[right];
            } else if(sum > k) {
                left++;
                if(left < S.length) sum -= S[left - 1];
            } else {
                int len = right - left + 1;
                if(len < minLen) {
                    ans = new int[] {left, right};
                    minLen = len;
                }
                right++;
                if(right < S.length) sum += S[right];
            }
        }

        return ans;
    }
}