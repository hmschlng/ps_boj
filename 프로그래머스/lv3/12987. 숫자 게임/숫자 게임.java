import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int ans = 0;
        for(int i = A.length-1, j = A.length-1; i >= 0 && j >= 0; --i, --j) {
            while(j >= 0 && B[i] <= A[j]) {
                --j;
            }
            if(j >= 0) ans++;
        }

        return ans;
    }
}