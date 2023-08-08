import java.util.*;

class Solution
{
    static Stack<Character> stack;
    public int solution(String s)
    {
        stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            }
            else {
                if(c == stack.peek()) {
                    stack.pop();
                }
                else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}