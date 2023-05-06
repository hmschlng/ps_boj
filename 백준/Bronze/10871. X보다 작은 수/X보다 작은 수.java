import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	static Integer N,X,num;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		while(st.hasMoreTokens()) {
			if((num=Integer.parseInt(st.nextToken())) < X) {
				sb.append(num).append(" ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}
}