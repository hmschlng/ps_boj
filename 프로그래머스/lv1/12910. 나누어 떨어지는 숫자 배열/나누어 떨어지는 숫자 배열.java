import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] sorted = arr.clone();
        // 
        Arrays.sort(sorted);
        // System.out.print(Arrays.toString(sorted));
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : sorted) {
            if(i % divisor == 0) {
                list.add(i);
            }
        }
        
        if(list.isEmpty()) {
            return new int[] {-1};
        }
        else {
            return list.stream().mapToInt(Integer::new).toArray();
        }
    }
}