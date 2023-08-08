class Solution
{
    public int solution(int n, int a, int b)
    {
        int pow = 0;
        for(int i = 1; i <= 20; i++) {
            if(Math.pow(2, i) == n) {
                pow = i;
                break;
            }
        }
        int match = findMatch(1, n, a, b, pow);
        return match;
    }
    
    public int findMatch(int src, int dest, int a, int b, int depth) {
        int mid = (src + dest) / 2;
        if(isIn(a, src, mid) && isIn(b, src, mid)) {
            return findMatch(src, mid, a, b, depth - 1);
        } else if(isIn(a, mid+1, dest) && isIn(b, mid+1, dest)) {
            return findMatch(mid+1, dest, a, b, depth - 1);
        } else return depth;
    }
    
    public boolean isIn(int target, int src, int dest) {
        return src <= target && target <= dest;
    }
}