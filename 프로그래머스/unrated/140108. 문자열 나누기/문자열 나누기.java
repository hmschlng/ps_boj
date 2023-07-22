class Solution {
    public int solution(String s) {
        int ans = 1;
        char[] letters = s.toCharArray();
        char init = s.charAt(0);
        int equal = 1, diff = 0;
        for(int i = 1; i < s.length(); i++) {
            if(equal == diff) {
                init = letters[i];
                equal = 1;
                diff = 0;
                ans++;
                continue;
            }
            if(letters[i] == init) {
                equal++;
                continue;
            }
            else {
                diff++;
            }
        }
        return ans;
    }
}