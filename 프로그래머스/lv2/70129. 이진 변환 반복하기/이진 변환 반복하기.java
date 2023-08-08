import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] res = new int[2];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        while(!s.equals("1")) {
            st = new StringTokenizer(s, "0");
            sb.setLength(0);
            while(st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
            
            res[0]++;
            res[1] += (s.length() - sb.length());
            
            s = Integer.toBinaryString(sb.length());
        }
        
        return res;
    }
}