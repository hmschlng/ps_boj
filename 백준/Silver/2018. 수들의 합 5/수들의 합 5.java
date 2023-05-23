import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		ans = 1;
		int left = 1, right = 2;
		int sum = left + right;

		while(left < N || right < N) {
			if(sum > N) 		sum -= (left++);
			else if(sum < N)	sum += (++right);
			else {
				ans++;
				sum -= (left++);
			}
		}
		System.out.println(ans);
	}
}