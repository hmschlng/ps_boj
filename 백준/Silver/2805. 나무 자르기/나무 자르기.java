import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // N: 나무의 수, M: 가져가야하는 나무 길이
	static long[] logs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		logs = new long[N];
		for (int i = 0; i < N; i++) {
			logs[i] = Long.parseLong(st.nextToken());
		}

		long up = binSrc();

		System.out.println(up - 1);
	}

	private static long binSrc() {
		long l = 0, r = Arrays.stream(logs).max().getAsLong() + 1;
		while (l < r) {
			long mid = (l + r) / 2;

			long cut = 0;
			for (int i = 0; i < N; i++) {
				if(mid < logs[i])
					cut += logs[i] - mid;
			}

			if(cut < M) {
				r = mid;
			}
			else {
				l = mid + 1;
			}
		}
		return r;
	}
}