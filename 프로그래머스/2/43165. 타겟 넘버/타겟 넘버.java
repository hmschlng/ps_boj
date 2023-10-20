import java.util.*;

class Solution {
    static int ans;
    
    public int solution(int[] numbers, int target) {
        ans = 0;
        bfs(numbers, target);
        return ans;
    }
    
    private void bfs(int[] numbers, int target) {
        Queue<int[]> q = new ArrayDeque<>();
        int first = numbers[0];
        
        q.offer(new int[] {0, first});
        q.offer(new int[] {0, -first});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == numbers.length - 1) {
                if(cur[1] == target) {
                    ans++;
                }
                continue;
            }
            
            for(int i = -1; i <= 1; i += 2) {
                int newVal = cur[1] + (numbers[cur[0] + 1] * i);
                q.offer(new int[]{cur[0] + 1, newVal});
            }
        }
    }
}