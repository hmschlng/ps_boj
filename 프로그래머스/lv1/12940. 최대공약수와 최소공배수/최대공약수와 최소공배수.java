class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[]{1,1};
        
        for(int i = 2; i <= Math.min(n,m); i++) {
            while(n%i == 0 && m % i == 0) {
                answer[0] *= i; 
                n /= i;
                m /= i;
            }
        }
        answer[1] = answer[0] * n * m;
        
        return answer;
    }
}