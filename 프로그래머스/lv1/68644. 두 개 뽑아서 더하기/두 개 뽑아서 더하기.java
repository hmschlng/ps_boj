import java.util.*;

class Solution {
    static int size;
    static int[] res;
    static Set<Integer> set;
    public int[] solution(int[] numbers) {
        size = numbers.length;
        set = new TreeSet<>();
        res = new int[2];
        comb(0,0, numbers);
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int i : set) {
            answer[idx++] = i;
        }
        return answer;
    }
    public void comb(int n, int r, int[] numbers) {
        if(n == 2) {
            set.add(res[0] + res[1]);
            return;
        }
        if(r >= size) {
            return;
        }
        res[n] = numbers[r];
        comb(n+1, r+1, numbers);
        res[n] = 0;
        comb(n, r+1, numbers);
    }
}