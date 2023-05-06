import java.io.*;

public class Main {

	static Integer N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}