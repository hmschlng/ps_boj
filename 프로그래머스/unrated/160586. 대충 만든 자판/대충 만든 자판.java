import java.util.*;
class Solution {
    static Map<Character, Integer> map;
    public int[] solution(String[] keymap, String[] targets) {
        map = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char letter = key.charAt(i);
                if(map.containsKey(letter)) {
                    map.put(letter, Math.min(map.get(letter), i+1));
                }
                else {
                    map.put(letter, i+1);
                }
            }
        }
        
        int[] ans = new int[targets.length];
        outer : for(int i = 0; i < targets.length; i++) {
            int strokeCnt = 0;
            for(char letter : targets[i].toCharArray()) {
                if(!map.containsKey(letter)) {
                    ans[i] = -1;
                    continue outer;
                }
                
                strokeCnt += map.get(letter);
            }
            ans[i] = strokeCnt;
        }
        return ans;
    }
}