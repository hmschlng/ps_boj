import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        return getWH((brown-4)/2, yellow);
    }
    public int[] getWH(int halfEdge, int yellow) {
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0) {
                int a = i;
                int b = yellow/i;
                if(a + b == halfEdge) {
                    int w = Math.max(a,b);
                    int h = Math.min(a,b);
                    return new int[]{w+2, h+2};
                }
            }
        }
        return null;
    }
}