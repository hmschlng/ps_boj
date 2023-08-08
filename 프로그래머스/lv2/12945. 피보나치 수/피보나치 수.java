class Solution {
    static final long MOD = 1_234_567;
    static long[] base = {1,0};
    static long[][] matrix = {
        {1,1},
        {1,0}
    };
    public int solution(int n) {
        return (int) mul(getPow(matrix, n-1)[0], base);
    }
    
    public long[][] getPow(long[][] matrix, int pow) {
        if(pow == 1) {
            return matrix;
        }
        if(pow % 2 == 0) {
            long[][] part = getPow(matrix, pow/2);
            return mul(part, part);
        }
        return mul(matrix, getPow(matrix, pow - 1));
    }
    
    public long[][] mul(long[][] m1, long[][] m2) {
        long[][] res = new long[2][2];
        
        res[0][0] = getVal(m1[0][0], m2[0][0], m1[0][1], m2[1][0]);
        res[0][1] = getVal(m1[0][0], m2[0][1], m1[0][1], m2[1][1]);
        res[1][0] = getVal(m1[1][0], m2[0][0], m1[1][1], m2[1][0]);
        res[1][1] = getVal(m1[1][0], m2[0][1], m1[1][1], m2[1][1]);
        
        return res;
    }
    public long mul(long[] m1, long[] m2) {
        return getVal(m1[0], m2[0], m1[1], m2[1]);
    }
    public long getVal(long a, long b, long c, long d) {
        return (((a*b) % MOD) + ((c*d) % MOD)) % MOD;
    }
}