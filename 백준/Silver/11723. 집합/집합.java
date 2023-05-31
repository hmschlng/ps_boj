import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
			switch (cmd) {
				case "add":
					set.add(value);
					break;
				case "remove":
					set.remove(value);
					break;
				case "check":
					sb.append(set.contains(value) ? 1 : 0).append("\n");
					break;
				case "toggle":
					if(set.contains(value)) set.remove(value);
					else set.add(value);
					break;
				case "all":
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
				case "empty":
					set = new TreeSet<>();
			}
		}
		System.out.print(sb);
	}
}