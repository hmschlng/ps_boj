import java.util.*;

class Solution {
    static List<Character> list;
    
    public int solution(String s) {
        list = new ArrayList<>();
        
        for(char c : s.toCharArray()) list.add(c);
        
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            list.add(list.remove(0));
            if(check()) ans++;
        }
        
        return ans;
    }
    
    public boolean check() {
        Stack<Character> stack = new Stack<>();
        
        for(char c : list) {
            switch(c) {
                case '(':case '{':case '[':
                    stack.push(c);
                    break;
                case ')':case '}':case ']':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '(' && c == ')' ||
                      stack.peek() == '{' && c == '}' ||
                      stack.peek() == '[' && c == ']')
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}