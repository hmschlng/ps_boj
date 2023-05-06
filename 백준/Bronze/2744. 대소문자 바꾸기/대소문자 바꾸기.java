import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		char[] str = br.readLine().toCharArray();

		for (int i = 0; i < str.length; i++) {
			if('A' <= str[i] && str[i] <= 'Z') 
				sb.append((char)(str[i] - 'A' + 'a'));
			else 
				sb.append((char)(str[i] - 'a' + 'A'));
		}
		System.out.print(sb.toString());
	}
}