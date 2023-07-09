class Solution {
    public int solution(String s) {
        if(s.charAt(0) == '-') {
            return Integer.parseInt(s.substring(1)) * -1;
        }
        return Integer.parseInt(s);
    }
}