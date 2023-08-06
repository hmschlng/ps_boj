import java.util.*;

class Solution {
    static int[] points = {0,3,2,1,0,1,2,3};
    static char[] types = {'R','T','C','F','J','M','A','N'};
    static Map<Character, Integer> map;
    public String solution(String[] survey, int[] choices) {
        map = new HashMap<>();
        for(char type : types) {
            map.put(type, 0);
        }
        for(int i = 0; i < survey.length; i++) {
            int choice = points[choices[i]];
            if(choice == 4) continue;
            char type = choices[i] < 4 ? survey[i].charAt(0) : survey[i].charAt(1);
            System.out.println(type);
            map.put(type, map.get(type) + choice);
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0, idx = 0; i < 4; i++) {
            int score1 = map.get(types[idx]);
            int score2 = map.get(types[idx+1]);
            sb.append(score1 >= score2 ? types[idx] : types[idx+1]);
            idx+=2;
        }
        return sb.toString();
    }
}