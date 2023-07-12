import java.util.*;

class Solution {
    static List<Integer> scores;
    public int solution(String dartResult) {
        scores = new ArrayList<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : dartResult.toCharArray()) {
            if(Character.isDigit(ch)) {
                sb.append(ch);
            } else if(Character.isLetter(ch)) {
                int score = Integer.parseInt(sb.toString()); 
                sb.setLength(0);
                scores.add(getBonus(score, ch));
            } else {
                getOption(ch, scores.size()-1);
            }
        }
        
        return scores.stream().mapToInt(x -> x).sum();
    }
    
    public int getBonus(int score, char type) {
        switch(type) {
            case 'S':
                return score;
            case 'D':
                return score * score;
            default:
                return score * score * score;
        }
    }
    
    public void getOption(char type, int lastIdx) {
        switch(type) {
            case '*':
                if(scores.size() > 1) {
                    scores.set(lastIdx-1, scores.get(lastIdx-1) * 2);
                }
                scores.set(lastIdx, scores.get(lastIdx) * 2);
                break;
            case '#':
                scores.set(lastIdx, scores.get(lastIdx) * -1);
                break;
        }
    }
}