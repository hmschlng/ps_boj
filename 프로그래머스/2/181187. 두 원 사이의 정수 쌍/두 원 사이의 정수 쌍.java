class Solution {
    static int ir, or;
    public long solution(int r1, int r2) {
        ir = Math.min(r1, r2);
        or = Math.max(r1, r2);
        
        long total = 1L;
        for(int y = 1; y < or; y++) {
            double left  = Math.pow(ir, 2) - Math.pow(y, 2);
            if(y <= ir)  left = Math.ceil(Math.sqrt(left));
            else        left = 0;
            
            double right = Math.floor(Math.sqrt(Math.pow(or, 2) - Math.pow(y, 2)));
            // System.out.println(left + " ~ " + right);
            total += (right - left + 1);
        }
        
        return 4 * total;

    }
}