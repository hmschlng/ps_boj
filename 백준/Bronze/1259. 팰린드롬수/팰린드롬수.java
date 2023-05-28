
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static char[] num;
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			num = br.readLine().toCharArray();

			if (num[0] == '0')
				break;

			stack = new Stack<>();

			for (int i = 0; i < num.length; i++) {
				if (i == num.length / 2 && num.length % 2 == 1)
					continue;
				if (stack.isEmpty() || stack.peek() != num[i]) {
					stack.push(num[i]);
				} else if (stack.peek() == num[i]) {
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}