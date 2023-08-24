import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[][] C = computers;
        boolean[] v = new boolean[C.length];
        int cnt = 0;
        
        for(int i = 0; i < C.length; i++) {
            if(v[i]) continue;
            bfs(C,v,i);
            cnt++;
        }
        
        return cnt;
    }
    
    public void bfs(int[][] C, boolean[] v, int src) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(v[cur]) continue;
            v[cur] = true;
            
            for(int i = 0; i < C[cur].length; i++) {
                if(v[i]) continue;
                if(C[cur][i] != 1) continue;
                q.offer(i);
            }
        }
    }
}