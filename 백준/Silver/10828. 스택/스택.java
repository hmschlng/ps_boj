import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static Stack<String> stack;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			switch (cmd[0]) {
				case "push":
					stack.push(cmd[1]);	break;
				case "pop":
					sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n"); break;
				case "size":
					sb.append(stack.size()).append("\n"); break;
				case "empty":
					sb.append(stack.isEmpty() ? "1" : "0").append("\n"); break;
				case "top":
					sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
}