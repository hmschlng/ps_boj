import java.util.*;

class Solution {
    static Map<Character, Integer> map;
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                answer[i] = i - map.get(s.charAt(i));                
            }
            else {
                answer[i] = -1;
            }
            map.put(s.charAt(i), i);
        }
        
        return answer;
    }
}