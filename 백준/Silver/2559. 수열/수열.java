import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] temps, sums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		temps = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temps[i] = Integer.parseInt(st.nextToken());
		}
		sums = new int[N - K + 1];
		int idx = 1;
		for (int i = 0; i < N; i++) {
			if (i - K < 0) {
				sums[0] += temps[i];
			} else {
				sums[idx] = sums[idx-1] + temps[i] - temps[i-K];
				idx++;
			}
		}
		System.out.println(Arrays.stream(sums).max().getAsInt());
	}
}