import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		ans = 0;

		for (int i = 0; i < N; i++) {
			int left = 0, right = N-1;
			while(true) {
				if(left == i) left++;
				else if(right == i) right--;
				if(left >= right) break;

				if (nums[left] + nums[right] > nums[i]) {
					right--;
				} else if (nums[left] + nums[right] < nums[i]) {
					left++;
				} else {
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}