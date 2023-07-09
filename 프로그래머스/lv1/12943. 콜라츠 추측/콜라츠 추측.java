class Solution {
    public int solution(int num) {
        long lNum = num;
        int cnt = 0;
        while(cnt <= 500 && lNum != 1) {
            if(lNum % 2 == 1)   lNum = (lNum * 3) + 1;
            else                lNum /= 2;
            cnt++;
        }
        if(lNum != 1) return -1;
        else          return cnt;
    }
}