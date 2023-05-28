import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int cnt = 1;
		sb.append("<");
		while (!list.isEmpty()) {
			if (cnt == K) {
				sb.append(list.remove(0)).append(", ");
				cnt = 1;
			} else {
				list.add(list.remove(0));
				cnt++;
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}