import java.util.*;

class Solution {
    static int[] pos;
    static int R, C;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    public int[] solution(String[] park, String[] routes) {
        R = park.length;
        C = park[0].length();
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    pos = new int[]{i,j};
                }
            }
        }
        StringTokenizer st;
        for(String cmd : routes) {
            st = new StringTokenizer(cmd);
            int way = getWay(st.nextToken().charAt(0));
            int dist = Integer.parseInt(st.nextToken());
            
            walk(park, way, dist);
        }
        
        return pos;
    }
    
    public void walk(String[] park, int way, int dist) {
        int step = 0;
        while(++step <= dist) {
            int nr = pos[0] + step * dr[way];
            int nc = pos[1] + step * dc[way];
            
            if(!isIn(nr, nc)) return;
            if(park[nr].charAt(nc) == 'X') return;
            
            if(step == dist) {
                pos = new int[]{nr, nc};
                return;
            }
        }
    }
    
    public boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
    
    public int getWay(char dir) {
        switch(dir) {
            case 'N': return 0;
            case 'E': return 1;
            case 'S': return 2;
            default: return 3;
        }
    }
}