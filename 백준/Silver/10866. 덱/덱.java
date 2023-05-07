import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static Deque<String> queue;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			switch (cmd[0]) {
				case "push_front":
					queue.offerFirst(cmd[1]);	break;
				case "push_back":
					queue.offerLast(cmd[1]);	break;
				case "pop_front":
					sb.append(queue.isEmpty() ? "-1" : queue.pollFirst()).append("\n"); break;
				case "pop_back":
					sb.append(queue.isEmpty() ? "-1" : queue.pollLast()).append("\n"); break;
				case "size":
					sb.append(queue.size()).append("\n"); break;
				case "empty":
					sb.append(queue.isEmpty() ? "1" : "0").append("\n"); break;
				case "front":
					sb.append(queue.isEmpty() ? "-1" : queue.getFirst()).append("\n"); break;
				case "back":
					sb.append(queue.isEmpty() ? "-1" : queue.getLast()).append("\n"); break;
			}
		}
		System.out.print(sb);
	}
}