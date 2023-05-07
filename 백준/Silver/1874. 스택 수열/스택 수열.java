import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		stack = new Stack<>();
		int i = 1, cnt = 0;
		while(cnt != N) {
			int num = Integer.parseInt(br.readLine());
			if(num > i) {
				do {
					stack.push(i++);
					sb.append("+").append("\n");
				} while (num != i - 1);
				stack.pop();
				sb.append("-").append("\n");
				cnt++;
			}
			else if(num < i) {
				if(stack.peek() == num) {
					stack.pop();
					sb.append("-").append("\n");
					cnt++;
				}
				else {
					sb.setLength(0);
					sb.append("NO");
					break;
				}
			}
			else {
				sb.append("+").append("\n");
				sb.append("-").append("\n");
				i++;
				cnt++;
			}
		}

		System.out.println(sb);
		// num이 i 보다 크면 스택에 해당 숫자가 나올때 까지 push, sb에 + 추가
		// num이 i와 같으면 sb에 +\n-\n 추가
		// num이 i보다 작으면 stack.peek과 비교, 같으면 pop, sb에 - 추가
		// 										다르면 sb.setLength(0), sb에 "NO" 추가
	}
}