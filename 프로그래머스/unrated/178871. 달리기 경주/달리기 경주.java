import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static String[] arr;
    public String[] solution(String[] players, String[] callings) {
        map = new HashMap<>();
        arr = new String[players.length];
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            arr[i] = players[i];
        }
        
        for(int i = 0; i < callings.length; i++) {
            String person = callings[i];
            int pos = map.get(person);
            String frontPerson = arr[pos-1];
            
            arr[pos-1] = person;
            map.put(person, map.get(person) - 1);
            arr[pos] = frontPerson;
            map.put(frontPerson, map.get(frontPerson) + 1);
        }
        return arr;        
    }
}