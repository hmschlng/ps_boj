import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (x,y) -> Integer.compare(x[0], y[0]));
        
        var pq = new PriorityQueue<int[]>((x,y) -> Integer.compare(x[1], y[1]));
        int time = 0;
        int sum = 0;
        int idx = 0;
        int cnt = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] proc = pq.poll();
                cnt++;
                time += proc[1];
                sum += (time - proc[0]);
            }
        }
        
        return sum/jobs.length;
    }
}