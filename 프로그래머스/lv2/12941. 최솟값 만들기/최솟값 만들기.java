import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int ans = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
                
        for(int i = 0, j = B.length - 1; i < A.length && j >= 0; i++, j--) {
            ans += A[i] * B[j];
        }

        return ans;
    }
}