import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long r = 31, M = 1_234_567_891;
	static int L;
	static int[] word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());

		String line = br.readLine();

		long hash = 0, pow = 1;
		for (int i = 0; i < L; i++) {
			hash += (line.charAt(i) - 'a' + 1) * pow;
			pow = (pow * r) % M;
		}
		System.out.println(hash % M);
	}
}