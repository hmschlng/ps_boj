import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			char[] scores = br.readLine().toCharArray();
			int total = 0, combo = 0;
			for (int j = 0; j < scores.length; j++) {
				if(scores[j] == 'X') combo = 0;
				else total += ++combo;
			}
			sb.append(total).append("\n");
		}
		System.out.print(sb);
	}
}