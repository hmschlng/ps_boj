import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static Stack<Integer> stack;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());

		stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}

		int count = 0;
		for (int i: stack) {
			count += i;
		}

		System.out.println(count);
	}
}