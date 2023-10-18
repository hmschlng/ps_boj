import java.util.*;

class Solution {
    static PriorityQueue<int[]> pq;
    
    public int solution(int[][] targets) {
        pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1]));
        for(int[] target : targets) {
            pq.offer(target);
        }
        
        int pos = -1;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] >= pos) {
                // System.out.println(Arrays.toString(cur));
                pos = cur[1];
                cnt++;
            }
        }
        
        return cnt;
    }
}