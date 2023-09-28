import java.util.*;

class Solution {
    static int R, C, H, ans;
    static boolean[][] v;
    static int[][] areaMap;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    
    public int solution(int[][] land, int height) {
        R = land.length;
        C = land[0].length;
        H = height;
        v = new boolean[R][C];
        
        bfs(land);
        
        return ans;
    }
    
    private void bfs(int[][] map) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[2], y[2]));
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(v[cur[0]][cur[1]]) continue;
            v[cur[0]][cur[1]] = true;
            ans += cur[2];
            
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                
                if(!isIn(nr, nc)) continue;
                
                int gap = Math.abs(map[nr][nc] - map[cur[0]][cur[1]]);
                if(gap <= H) gap = 0;
                
                pq.offer(new int[] {nr, nc, gap});
            }
        }
    }
    
    private boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}