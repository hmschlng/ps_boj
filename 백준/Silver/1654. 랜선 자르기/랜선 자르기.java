import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static long[] lines;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new long[K];
		for (int i = 0; i < K; i++) {
			lines[i] = Long.parseLong(br.readLine());
		}

		long upperBound = binarySearch();

		System.out.println(upperBound - 1);
	}

	private static long binarySearch() {
		long start = 0;
		long end = Arrays.stream(lines).max().getAsLong() + 1;

		long mid = 0;
		while (start < end) {
			mid = (end + start) / 2;

			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += lines[i] / mid;
			}

			if (sum < N) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
}