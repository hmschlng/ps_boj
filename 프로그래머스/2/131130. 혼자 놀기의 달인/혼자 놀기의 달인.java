import java.util.*;

class Solution {
    static final int R = 2;
    static int len, ans;
    static int[] res = new int[2];
    static int[] card;
    public int solution(int[] cards) {
        card = cards;
        len = cards.length;
        ans = 0;
        comb(new boolean[len],0,0);
        return ans;
    }
    
    private void comb(boolean[] v, int idx, int r) {
        if(r == R) {
            // System.out.println(Arrays.toString(res));
            int score = play();
            ans = Math.max(ans, score);
            return;
        }
        
        for(int i = idx; i < len; i++) {
            if(v[i]) continue;
            res[r] = i;
            v[i] = true;
            comb(v, idx+1, r+1);
            res[r] = 0;
            v[i] = false;
        }
    }
    
    private int play() {
        int idx = res[0];
        boolean[] v = new boolean[len];
        int cnt = 0,
            score = 0;
        while(!v[idx]) {
            cnt++;
            v[idx] = true;
            idx = card[idx] - 1;
        }
        score += cnt;
        // System.out.print(" -> " + cnt);
        cnt = 0;
        idx = res[1];
        while(!v[idx]) {
            cnt++;
            v[idx] = true;
            idx = card[idx] - 1;
        }
        score *= cnt;
        // System.out.print("*" + cnt + "= " + score);
        // System.out.println();
        return score;
    }
}