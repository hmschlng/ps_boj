import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int A,B;

	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A; i++)	pq.offer(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B; i++)	pq.offer(Integer.parseInt(st.nextToken()));


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A + B; i++) {
			sb.append(pq.poll()).append(" ");
		}

		System.out.print(sb);
	}
}