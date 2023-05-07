import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] word = br.readLine().toCharArray();

		int i = Integer.parseInt(br.readLine()) - 1;
		System.out.print(word[i]);

	}
}