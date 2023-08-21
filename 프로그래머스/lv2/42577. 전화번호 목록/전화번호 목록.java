import java.util.*;

class Solution {
    static TreeSet<String> set;
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        set = new TreeSet<>();
        
        for(String num : phone_book) {
            if(!set.isEmpty()) {
                for(int i = 1; i < num.length(); i++) {
                    String s = num.substring(0,i);
                    if(set.contains(s)) {
                        return false;
                    }
                }
            }
            set.add(num);
        }
        
        return true;
    }
}