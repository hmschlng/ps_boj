import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static Integer A,B;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		StringBuilder sb = new StringBuilder();

		// while(true) {
		// 	String[] lines = br.lines().toArray(String[]::new);
			// line = br.readLine();
			// System.out.println(Arrays.toString(lines));
		// }
		//
		while((line=br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			if(!st.hasMoreTokens()) break;
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sb.append(A+B).append("\n");
		}

		System.out.print(sb.toString());
	}
}