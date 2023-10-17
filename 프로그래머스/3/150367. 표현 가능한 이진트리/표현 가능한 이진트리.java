import java.util.*;

class Solution {
    static final int MAX = 50; // 10^15 < 2^50 이므로, 50까지가 최대 이진수
    static boolean[] tree;
    static int[] ans;

    public int[] solution(long[] numbers) {
        ans = new int[numbers.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            
            int exp = 1;
            int size = 0;
            while(size < bin.length()) {
                size = (int)Math.pow(2, exp++) - 1;
            }

            tree = new boolean[size];
            int idx = size - bin.length();
            for(int j = 0; j < bin.length(); j++, idx++) {
                tree[idx] = bin.charAt(j) == '1';
            }

            dfs(0, size-1, false, i);
        }

        return ans;
    }

    private void dfs(int left, int right, boolean isParentZero, int idx) {
        int mid = (left + right) / 2;
        if(isParentZero && tree[mid]) { //루트가 0이면 자식노드들에서 1이나오면 안됨
            ans[idx] = 0;
            return;
        }

        // 내가 마지막 노드가 아니면 재귀
        if(left != right) {
            dfs(left, mid-1, !tree[mid], idx); // 왼쪽, 현재 루트가 더미이면 isParentZero = true
            dfs(mid+1, right, !tree[mid], idx); // 오른쪽
        }

    }
}