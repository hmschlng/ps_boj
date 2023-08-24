class Solution {
   public int solution(int n, int[] stations, int w) {
       int range = (2 * w) + 1;
       int prev = 0;
       int cur = -1;

       int cnt = 0;
       for(int i = 0; i < stations.length; i++) {
           cur = stations[i];
           int noService = cur - prev - range;
           if(i == 0) noService += w;
           if(noService > 0) {
               cnt += noService / range;
               cnt += (noService % range > 0) ? 1 : 0;
           }
           prev = cur;
       }

       int rest = n - prev - w;

       if(rest > 0) {
           cnt += rest / range;
           cnt += (rest % range > 0) ? 1 : 0;
       }

       return cnt;
   }
}