import java.util.*;

class Solution {
    static Set<Integer> set;
    public int solution(int[] nums) {
        int limit = nums.length / 2;
        set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() > limit ? limit : set.size();
    }
}