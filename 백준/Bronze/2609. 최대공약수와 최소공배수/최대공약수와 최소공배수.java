import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		int gcd = 0, lcm = 0;
		int num = 1;
		while(lcm == 0) {
			if(A % num == 0 && B % num == 0) {
				gcd = num;
			}
			if(num % A == 0 && num % B == 0) {
				lcm = num;
				break;
			}
			num++;
		}

		System.out.println(gcd);
		System.out.println(lcm);
	}
}