import java.util.*;

class Solution {
    public String solution(String new_id) {
        String res1 = p1(new_id);
        String res2 = p2(res1);
        String res3 = p3(res2);
        String res4 = p4(res3);
        String res5 = p5(res4);
        String res6 = p6(res5);
        String res7 = p7(res6);
        return res7;
    }
    
    public String p1(String s) {
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(letters[i]) && Character.isUpperCase(letters[i])) {
                letters[i] = Character.toLowerCase(letters[i]);
            }
        }
        sb.append(letters);
        return sb.toString();
    }
    
    public String p2(String s) {
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            char c = letters[i];
            if(c == '-' || c == '_' || c == '.') {
                sb.append(c);
                continue;
            } if(Character.isDigit(c)) {
                sb.append(c);
                continue;
            } if(Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
        }
        return sb.toString();
    }
    
    public String p3(String s) {
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();      
        
        boolean isDoubleDot = false;
        for(int i = 0; i < s.length(); i++) {
            char c = letters[i];
            if(c == '.') {
                if(!isDoubleDot) {
                    isDoubleDot = true;
                }
            }
            else {
                if(isDoubleDot) {
                    isDoubleDot = false;
                    sb.append('.');                    
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }
        
    public String p4(String s) {
        if(s.isEmpty()) return s;
        int start = 0, end = s.length();
        if(s.charAt(0) == '.') {
            start++;
        }
        if(start < end && s.charAt(s.length()-1) == '.') {
            end--;
        }
        return s.substring(start, end);        
    }
    
    public String p5(String s) {
        return (s.isEmpty()) ? "a" : s;
    }
        
    public String p6(String s) {
        String res = (s.length() >= 16) ? s.substring(0,15) : s;
        if(res.charAt(res.length()-1) == '.') {
            return res.substring(0, res.length()-1);
        }
        return res;
    }
        
    public String p7(String s) {
        if(s.length() > 2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        char c = s.charAt(s.length()-1);
        while(sb.length() < 3) {
            sb.append(c);
        }
        return sb.toString();
    }
}