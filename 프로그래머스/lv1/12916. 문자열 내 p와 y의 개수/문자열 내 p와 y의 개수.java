class Solution {
    boolean solution(String s) {
        int cnt=0;        
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'P': case 'p':
                    cnt++;
                    break;
                case 'Y': case 'y':
                    cnt--;
                    break;
            }
        }
        return cnt == 0 ? true : false;
    }
}