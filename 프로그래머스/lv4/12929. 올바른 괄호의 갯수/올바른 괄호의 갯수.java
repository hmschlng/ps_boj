import java.util.*;

class Solution {
    static Set<String> set;
    static int maxLen;
    public int solution(int n) {
        set = new HashSet<>();
        maxLen = n * 2;
        dfs(0, 0, 0, "");
        
        return set.size();
    }
    
    public void dfs(int left, int right, int len, String str) {
        if(left < right || left > maxLen/2 || right > maxLen/2) return;
        
        if(len == maxLen) {
            if(left == right) {
                set.add(str);
            }
            return ;
        }
        
        dfs(left + 1, right, len + 1, str + "(");
        dfs(left, right + 1, len + 1, str + ")");
    }
}