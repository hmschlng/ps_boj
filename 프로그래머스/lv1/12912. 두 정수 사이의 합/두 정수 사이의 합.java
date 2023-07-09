class Solution {
    public long solution(int a, int b) {
        int start = Math.min(a,b);
        int end = Math.max(a,b);
        long ans = start;
        for(int i = start + 1; i <= end; i++) {
            ans += i;
        }
        return ans;
    }
}