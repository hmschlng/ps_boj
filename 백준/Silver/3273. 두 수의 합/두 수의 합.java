
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, X, ans;
	static int[] seq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(br.readLine());
		
		seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(seq);
		int left = 0, right = N-1, ans = 0;
		while(left < right) {
			if(seq[left] + seq[right] > X) right--;
			else if(seq[left] + seq[right] < X) left++;
			else {
				ans++;
				left++;
			}
		}
		System.out.println(ans);
	}
}