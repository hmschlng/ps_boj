import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new TreeSet<>();
        int size = elements.length;
        int[] nums = new int[size * 2];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < size; j++) {
                nums[(elements.length * i) + j] = elements[j];
            }
        }
        // System.out.println(Arrays.toString(nums));
        
        int[][] sums = new int[size][size*2];
        int sum = Arrays.stream(elements).sum();
        
        for(int i = 0; i < size; i++) {
            for(int j = i; j < i + size; j++) {
                if(j == 0) {
                    sums[i][j] = nums[j];
                    set.add(sums[i][j]);
                    continue;
                }
                
                if(j - i >= size) {
                    sums[i][j] = sums[i][j-1] - sums[i][j - size] + nums[j];
                } else {
                    sums[i][j] = sums[i][j-1] + nums[j];
                }
                set.add(sums[i][j]);
            }
        }
        // for(int[] a : sums) System.out.println(Arrays.toString(a));
        // for(int i : set) System.out.print(i + " ");
        // System.out.println();
        return set.size();
    }
}