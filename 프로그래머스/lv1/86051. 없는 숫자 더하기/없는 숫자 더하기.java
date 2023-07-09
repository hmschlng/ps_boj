class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        boolean[] digit = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            digit[numbers[i]] = true;
        }
        for(int i = 0; i < 10; i++) {
            if(!digit[i]) ans += i;
        }
        return ans;
    }
}