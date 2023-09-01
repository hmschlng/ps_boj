import java.util.*;

class Solution {
    static int ans;
    static Set<Set<String>> set;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        ans = 0;    
        
        dfs(user_id, banned_id, 0, new boolean[user_id.length], new HashSet<>());
        
        return set.size();
    }
    
    public void dfs(String[] u, String[] b, int idx, boolean[] v, Set<String> select) {
        if(idx == b.length) {
            set.add(select);
            return;
        }
        
        for(int i = 0; i < u.length; i++) {
            if(v[i]) continue;
            if(!check(u[i], b[idx])) continue;
            
            v[i] = true;
            Set<String> update = new HashSet<>();
            for(String id : select) {
                update.add(id);
            }
            update.add(u[i]);
            dfs(u, b, idx + 1, v, update);
            v[i] = false;
        }
        
    }
    
    public boolean check(String id, String censored) {
        if(id.length() != censored.length()) return false;
        
        for(int i = 0; i < id.length(); i++) {
            if(censored.charAt(i) != '*' && censored.charAt(i) != id.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}