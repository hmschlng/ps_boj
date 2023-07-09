import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
        }
        int w = 0;
        int h = 0;
        for(int i = 0; i < sizes.length; i++) {
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        return w * h;
    }
}