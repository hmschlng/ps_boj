import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    public int[] solution(int k, int[] score) {
        pq = new PriorityQueue<>();
        
        int[] ans = new int[score.length];
        pq.offer(score[0]);
        ans[0] = score[0];
        
        for(int i = 1; i < score.length; i++) {
            int lowest = pq.poll();
            if(i < k) {
                pq.offer(score[i]);
            } else {
                if(score[i] > lowest) {
                    lowest = score[i];
                }
            }
            pq.offer(lowest);
            ans[i] = pq.peek();
        }
        return ans;
    }
}