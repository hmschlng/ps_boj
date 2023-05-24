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
		// 투포인터 셋업
		int left = 0, right = 0, sum = arr[left];

		while(left < N && right < N) {	// 배열의 범위를 넘어가지 않는 선에서 반복
			if(sum > M) {				// 현재 총합이 M보다 크면
				sum -= arr[left++];		// 왼쪽 범위를 한칸 제회한다.
			} else if(sum < M) {		// 현재 총합이 M보다 작으면
				right++;				// 오른쪽 포인터를 한칸 오른쪽으로 옮긴다.
				if(right < N) {			// 만약 오른쪽 포인터가 배열의 범위를 벗어나지 않는다면
					sum += arr[right];	// 옮겨진 오른쪽 포인터에 해당하는 배열의 값을 더한다.
				}
			} else {					// 현재 총합이 M과 같으면
				ans++;					// 경우의 수 하나 증가
				sum -= arr[left++];		// 왼쪽 포인터에 해당하는 배열의 값을 빼고, 포인터를 하나 오른쪽으로 옮긴다.
			}
		}

		System.out.println(ans);
	}
}