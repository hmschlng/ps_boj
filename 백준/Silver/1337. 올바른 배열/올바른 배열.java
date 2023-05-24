import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int N;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}

		int min = Integer.MAX_VALUE;
		for (int i : set) {
			int left = i+1, right = i+5, cnt = 0;
			for (int j = i+1; j <= i+4; j++) {
				if(!set.contains(j)) cnt++;
			}
			min = Math.min(cnt, min);
		}

		System.out.println(min);
	}
}