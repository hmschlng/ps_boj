import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Integer> line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		line = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			line.add(line.size()-num, i);
		}

		StringBuilder sb = new StringBuilder();

		for (int student : line) {
			sb.append(student).append(" ");
		}
		System.out.print(sb.toString());
	}
}