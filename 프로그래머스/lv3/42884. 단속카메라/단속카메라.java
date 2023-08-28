import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1]));
        // routes = Arrays.stream(routes).sorted((x,y) -> Integer.compare(x[1], y[1])).toArray(int[][]::new);
        // for(int[] a : routes) System.out.println(Arrays.toString(a));
        
        for(int[] route : routes) pq.offer(route);
        
        int ans = 1;
        int pos = pq.poll()[1];
        
        while(!pq.isEmpty()) {
            int[] route = pq.poll();
            if(route[0] > pos) {
                pos = route[1];
                ans++;
                // System.out.println(Arrays.toString(routes[i]));
            }
        }
        return ans;
    }
}