import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int N;
	static Set<String> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		pq = new TreeSet<>((x, y) -> {
			if(x.length() == y.length()) {
				return x.compareTo(y);
			} else {
				return x.length() - y.length();
			}
		});

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			pq.add(word);
		}
		
		StringBuilder sb = new StringBuilder();
		for(String s : pq) {
			sb.append(s).append("\n");
		}
		
		System.out.print(sb);
	}
}