import java.util.*;

class Solution {
    static int R, C;
    static int[] dr = {0,0,1,-1}, dc = {1,-1,0,0}; // 동-서-남-북
    
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        
        int answer = bfs(maps);
        return answer;
    }
    
    private int bfs(int[][] map) {
        int res = -1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[R][C];
        q.offer(new int[] {0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(cur[0] == R-1 && cur[1] == C-1) {
                res = cur[2];
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(!isIn(nr, nc))       continue;
                if(v[nr][nc])           continue;
                if(map[nr][nc] == 0)    continue;
                
                q.offer(new int[]{nr, nc, cur[2] + 1});
                v[nr][nc] = true;
            }
        }
        
        return res;
    }
    
    private boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
    
}