class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int rest = n%2;
        for(int i = 0; i < n/2; i++) {
            sb.append("수박");
        }
        
        return rest == 1 ?
            sb.append("수").toString() : 
            sb.toString();
    }
}