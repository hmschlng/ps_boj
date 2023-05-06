import java.io.*;
import java.util.*;

public class Main {

	static Integer N;
	static StringBuilder sb;
	static boolean[] submitted;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		submitted = new boolean[30+1];
		for (int i = 0; i < 28; i++) {
			N = Integer.parseInt(br.readLine());
			submitted[N] = true;
		}
		for (int i = 1; i < 31; i++) {
			if(!submitted[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}