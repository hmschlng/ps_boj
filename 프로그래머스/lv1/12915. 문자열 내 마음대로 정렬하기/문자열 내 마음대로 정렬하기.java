import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Word[] words = new Word[strings.length];
        for(int i = 0; i < strings.length; i++) {
            words[i] = new Word(strings[i], n);
        }
        Arrays.sort(words);
        
        String[] answer = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            answer[i] = words[i].s;
        }
        return answer;
    }
}

class Word implements Comparable<Word>{
    String s;
    int n;
    public Word(String s, int n) {
        this.s = s;
        this.n = n;
    }
    public int compareTo(Word o) {
        if(this.s.charAt(this.n) == o.s.charAt(this.n)) {
            return this.s.compareTo(o.s);
        } else {
            return Integer.compare(this.s.charAt(this.n), o.s.charAt(this.n));
        }
    }
}