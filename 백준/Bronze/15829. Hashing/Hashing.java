import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long r = 31, M = 1_234_567_891;
	static int L;
	static int[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());

		word = Arrays.stream(br.readLine().split(""))
			.mapToInt((x) -> x.charAt(0) - 'a' + 1).toArray();

		long hash = 0;
		for (int i = 0; i < L; i++) {
			hash += word[i] * (long) Math.pow(r, i) % M;
		}

		System.out.println(hash);
	}
}