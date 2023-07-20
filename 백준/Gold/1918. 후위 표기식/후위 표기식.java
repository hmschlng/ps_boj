import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] expression = sb.append("(").append(br.readLine()).append(")")
                .toString().toCharArray();

        Stack<Character> stack = new Stack<>();

        sb.setLength(0);
        for (int i = 0; i < expression.length; i++) {
            switch(expression[i]) {
                case '(':
                    stack.push(expression[i]);
                    break;
                case ')':
                    while(stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                case '+': case '-':
                    while(stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.push(expression[i]);
                    break;
                case '*': case '/':
                    while(true) {
                        if(stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') break;
                        sb.append(stack.pop());
                    }
                    stack.push(expression[i]);
                    break;
                default:
                    sb.append(expression[i]);
            }
        }
        System.out.println(sb);
        
    }
}