class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        
        int share = s / n, 
            remain = s % n;
        
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(i >= n - remain) {
                ans[i] = share + 1;
            } else {
                ans[i] = share;
            }
        }
        return ans;
    }
}