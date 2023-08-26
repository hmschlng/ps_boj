import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq;
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        for(int work : works) {
            pq.offer(work);
        }
        for(int i = 0; !pq.isEmpty() && i < n; i++) {
            int w = pq.poll();
            if(--w > 0) pq.offer(w);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}