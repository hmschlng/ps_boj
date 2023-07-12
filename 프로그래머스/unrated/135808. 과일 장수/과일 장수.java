import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    public int solution(int k, int m, int[] score) {
        pq = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        
        for(int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
        }
        
        int ans = 0;
        while(pq.size() >= m) {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++) {
                min = Math.min(min, pq.poll());
            }
            ans += (min * m);
        }
        return ans;
    }
}