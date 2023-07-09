import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        int idx = 0;
        while(budget > 0 && idx < d.length) {
            if(budget - d[idx] < 0) break;

            answer++;
            budget -= d[idx++];
        }
        return answer;
    }
}