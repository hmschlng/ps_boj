import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        if(tangerine.length == 1) return 1;
        
        Arrays.sort(tangerine);
        // System.out.println(Arrays.toString(tangerine));
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        int prev = tangerine[0];
        int cnt = 1;
        
        for(int i = 1; i < tangerine.length; i++) {
            int cur = tangerine[i];
            
            if(prev != cur) {
                pq.offer(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
            prev = cur;
            
            if(i == tangerine.length - 1) {
                pq.offer(cnt);
            }
        }
        int ans = 0;
        while(k > 0) {
            int amount = pq.poll();
            k -= amount;
            ans++;
        }
        return ans;
    }
}
