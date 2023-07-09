class Solution {
    public int solution(String t, String p) {
        int left = 0;
        int right = p.length();
        int answer = 0;
        
        while(right <= t.length()) {
            String tSub = t.substring(left, right);
            if(Long.parseLong(tSub) <= Long.parseLong(p)) {
                answer++;
            }
            
            left++;
            right++;
        }
        return answer;
    }
}