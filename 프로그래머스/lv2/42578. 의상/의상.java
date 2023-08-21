import java.util.*;

class Solution {
    static Map<String, Integer> map;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        for(String[] item : clothes) {
            if(map.containsKey(item[1])) {
                map.put(item[1], map.get(item[1]) + 1);
            }
            else {
                map.put(item[1], 1);
            }
        }
        int answer = 1;
        for(int amount : map.values()) {
            answer *= (amount + 1);
        }
        return answer -1;
    }
}