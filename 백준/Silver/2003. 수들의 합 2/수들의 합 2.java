import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ans = 0;
		int left = 0, right = 0, sum = arr[left];
		while(left < N && right < N) {
			if(sum > M) {
				sum -= arr[left++];
			} else if(sum < M) {
				if(right < N - 1) {
					sum += arr[++right];
				} else {
					right++;
				}
			} else {
				ans++;
				sum -= arr[left++];
			}
		}

		System.out.println(ans);
	}
}