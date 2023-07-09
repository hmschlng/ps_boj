import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(min);
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            answer[idx++] = arr[i];
        }
        return answer;
    }
}