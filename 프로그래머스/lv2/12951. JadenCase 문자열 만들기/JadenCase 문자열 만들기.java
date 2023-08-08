import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                start = false;
                sb.append(c);
            }
            else {
                if(start) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    if(Character.isDigit(c)) {
                        sb.append(c);
                    }
                    else {
                        sb.append(Character.toUpperCase(c));
                    }
                    start = true;
                } 
            }
        }
        return sb.toString();
    }
}