class Solution {
    public long solution(long n) {
        for (long i = 1; i <= (long)Math.sqrt(n); i++) {
            if((long)(i*i) == n) {
                return (long)(i+1)*(i+1);
            }
        }
        return -1;
    }
}