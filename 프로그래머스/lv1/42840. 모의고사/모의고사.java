import java.util.*;

class Solution {
    static int[][] supo = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}};
    
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int s = 0; s < 3; s++) {
                if(supo[s][i%supo[s].length] == answers[i]) {
                    scores[s]++;
                }            
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int max = Arrays.stream(scores).max().getAsInt();
        for(int i = 0; i < 3; i++) {
            if(max == scores[i]) {
                ans.add(i+1);
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}