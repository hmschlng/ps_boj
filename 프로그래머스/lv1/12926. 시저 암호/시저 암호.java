import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] letter = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(letter[i] == ' ') continue;
            
            if('A' <= letter[i] && letter[i] <= 'Z') {
                letter[i] = (char) ('A' + ((letter[i] - 'A' + n) % 26));
            }
            else {
                letter[i] = (char) ('a' + ((letter[i] - 'a' + n) % 26));
            }
        }
        return sb.append(letter).toString();
    }
}