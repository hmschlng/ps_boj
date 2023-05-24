import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, S, ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}


		ans = Integer.MAX_VALUE;
		int left = 0, right = 0, sum = arr[0], range = 1, cnt = 0;

		while(left < N && right < N) {
			if(sum < S) {
				right++;
				if(right < N) {
					sum += arr[right];
					range++;
				}
			} else {
				cnt++;
				while(sum - arr[left] >= S) {
					sum -= arr[left++];
					range--;
				}
				ans = Math.min(ans, range);
				sum -= arr[left++];
				range--;
			}
		}

		if(cnt == 0) {
			System.out.println(0);
		}
		else {
			System.out.println(ans);
		}
	}
}