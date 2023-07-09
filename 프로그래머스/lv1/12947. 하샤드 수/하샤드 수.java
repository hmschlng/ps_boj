class Solution {
    public boolean solution(int x) {
        StringBuilder sb = new StringBuilder();
        
        char[] num = sb.append(x).toString().toCharArray();
        int hashad = 0;
        for(char digit : num) {
            hashad += digit-'0';
        }
        return x % hashad == 0;
    }
}