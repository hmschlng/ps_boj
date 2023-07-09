class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        int div = 3;
        while(n > 0) {
            sb.append(n%div);
            n/=div;
        }
        char[] digit = sb.toString().toCharArray();
        int answer = 0, mul = 1;
        for(int i = digit.length - 1; i >= 0; i--) {
            answer += (digit[i] - '0') * mul;
            mul *= 3;
        }
        return answer;
    }
}