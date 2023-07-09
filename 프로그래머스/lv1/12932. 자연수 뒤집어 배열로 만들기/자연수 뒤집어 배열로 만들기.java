class Solution {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb = sb.reverse();
        char[] arr = sb.toString().toCharArray();
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] - '0';
        }
        return answer;
    }
}