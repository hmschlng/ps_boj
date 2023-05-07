import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] line;
	static int N, pair;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			line = br.readLine().toCharArray();
			pair = 0;
			boolean res = false;

			for (int j = 0; j < line.length; j++) {
				if(pair < 0) {
					res = false;
					break;
				}
				else if(line[j] == '(') {
					pair++;
				}
				else {
					pair--;
				}
			}
			if(pair == 0) res = true;
			
			sb.append(res ? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
	}
}