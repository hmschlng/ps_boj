import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static PriorityQueue<Info> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		pq = new PriorityQueue<>((x,y) -> {
			if (x.age == y.age) {
				return Integer.compare(x.idx, y.idx);
			} else
				return Integer.compare(x.age, y.age);
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Info(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Info info = pq.poll();
			sb.append(info.age).append(" ").append(info.name).append("\n");
		}
		System.out.print(sb);
	}

	static class Info {
		int age;
		int idx;
		String name;

		public Info(int age, int idx, String name) {
			this.age = age;
			this.idx = idx;
			this.name = name;
		}
	}
}