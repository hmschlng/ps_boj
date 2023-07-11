class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] | arr2[i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr1.length; i++) {
            for(int j = n-1; j >= 0; j--) {
                if((arr1[i] & 1 << j) != 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();            
            sb.setLength(0);
        }
        return answer;
    }
}