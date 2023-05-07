import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long A,B,C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		A = Long.parseLong(br.readLine());
		B = Long.parseLong(br.readLine());
		C = Long.parseLong(br.readLine());

		char[] num = String.valueOf(A*B*C).toCharArray();
		int[] numbers = new int[10];
		for (int i = 0; i < num.length; i++) {
			numbers[(int)(num[i]-'0')]++;
		}

		for (int i = 0; i < 10; i++) {
			sb.append(numbers[i]).append("\n");
		}

		System.out.print(sb);
	}
}