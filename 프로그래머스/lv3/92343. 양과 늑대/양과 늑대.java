import java.util.*;

class Solution {
    static final int SHEEP = 0;
    static int ans;

    public int solution(int[] info, int[][] edges) {
        ans = 0;
        solve(0, 0, 0, new boolean[info.length], info, edges);
        return ans;
    }

    public void solve(int cur, int sheepCnt, int wolfCnt, boolean[] v, int[] info, int[][] edges) {
        v[cur] = true;

        if(info[cur] == SHEEP) {
            sheepCnt++;
            ans = Math.max(ans, sheepCnt);
        } else {
            wolfCnt++;
        }

        if(sheepCnt <= wolfCnt) {
            return;
        }

        for(int[] node : edges) {
            if(v[node[1]]) continue;
            if(v[node[0]]) {
                boolean[] newV = v.clone();
                solve(node[1], sheepCnt, wolfCnt, newV, info, edges);
            }
        }
    }
}