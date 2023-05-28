import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>((x,y) -> Integer.compare(x,y));
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num  = pq.poll();
			sb.append(num).append("\n");
		}
		System.out.print(sb);
	}
}