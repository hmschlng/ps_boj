class Solution {
    public boolean solution(String s) {
        try {
            if(s.length() == 4 || s.length() == 6) {
                int i = Integer.parseInt(s);
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }
}