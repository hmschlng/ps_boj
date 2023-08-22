import java.util.*;

class Solution {
    static TreeMap<Integer, Integer> map;
    public int[] solution(String[] operations) {
        map = new TreeMap<>();
        
        for(String operation :  operations) {
            String[] op = operation.split(" ");
            char cmd = op[0].charAt(0);
            int val = Integer.parseInt(op[1]);
            switch(cmd) {
                case 'I':
                    map.put(val, map.getOrDefault(val, 0) + 1);
                    break;
                case 'D':
                    if(map.isEmpty()) break;
                    
                    int key = (val == -1) ? map.firstKey() : map.lastKey();
                    
                    if(map.get(key) > 1) {
                        map.put(key, map.get(key) - 1);
                    } else {
                        map.remove(key);
                    }
            }
        }
        return map.isEmpty() ? new int[] {0,0} : new int[] {map.lastKey(), map.firstKey()};
    }
}