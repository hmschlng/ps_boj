import java.util.*;

class Solution {
    static int[][] T;
    public int solution(int[][] triangle) {
        T = triangle;
        
        for(int i = 1; i < T.length; i++) {
            for(int j = 0; j < T[i].length; j++) {
                if(j == T[i].length - 1) {
                    T[i][j] += T[i-1][j-1];
                } else if(j == 0) {
                    T[i][j] += T[i-1][0];
                } else {
                    T[i][j] += Math.max(T[i-1][j-1], T[i-1][j]);
                }
            }
        }
        
        return Arrays.stream(T[T.length-1]).max().getAsInt();
    }
}