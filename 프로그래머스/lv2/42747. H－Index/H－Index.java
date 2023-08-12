import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = citations.length-1; i >= 0; i--) {
            min = Math.min(min, citations[i]);
                        
            if((citations.length - i) <= min) idx = (citations.length - i);
        }
        return idx;
    }
}