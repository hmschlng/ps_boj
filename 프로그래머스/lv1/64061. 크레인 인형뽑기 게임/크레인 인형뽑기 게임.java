import java.util.*;

class Solution {
    static final int EMPTY = 0;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        
        for(int pos : moves) {
            for(int i = 0; i < board.length; i++) {
                int doll = board[i][pos-1];
                if(doll == EMPTY) continue;
                
                board[i][pos-1] = 0;
                if(!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    ans+=2;
                }
                else {
                    stack.push(doll);
                }
                
                break;
            }
        }
        return ans;
    }
}