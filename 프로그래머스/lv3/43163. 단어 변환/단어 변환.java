import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean isPossible = false;
        for(String word : words) {
            if(word.equals(target)) {
                isPossible = true;
                break;
            }
        }
        if(!isPossible) return 0;
        
        int ans = bfs(begin, target, words);
        return ans;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Word> q = new ArrayDeque<>();
        boolean[] v = new boolean[words.length];
        
        q.offer(new Word(begin, -1, 0));
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            // System.out.println(cur.cnt);
            // System.out.print(cur.val + " -> ");
            if(target.equals(cur.val)) {
                return cur.cnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(v[i]) continue;
                if(!check(cur.val, words[i])) continue;
                // System.out.print(words[i] + " ");
                q.offer(new Word(words[i], i, cur.cnt+1));
                v[i] = true;
            }
            // System.out.println();
        }
        
        return 0;
    }
    
    public boolean check(String s1, String s2) {
        int cnt = 0;
        for(int i = 0 ; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if(cnt > 1) return false;
        }
        return true;
    }
}
class Word {
    String val;
    int idx;
    int cnt;
    
    public Word(String val, int idx, int cnt) {
        this.val = val;
        this.idx = idx;
        this.cnt = cnt;
    }
}