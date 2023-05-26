import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {
	static int N, d, k, c, ans;
	static int[] table;
	static Map<Integer, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		// 앞의 k 개 만큼을 뒤에 추가로 붙여 원형 테이블처럼 세팅
		table = new int[N + k];
		for (int i = 0; i < N; i++) {
			int sushi = Integer.parseInt(br.readLine());
			if(i < k) {
				table[i] = table[i + N] = sushi;
			} else {
				table[i] = sushi;
			}
		}

		map = new HashMap<>();
		ans = 0;
		int left = 0, right = 0;
		
		// k 개 이하의 개수인 초밥을 미리 채워둠
		while(right < k) {
			compute(table[right++], '+');
		}

		while(left < N && right < N + k) {
			// scope 에서 벗어난 초밥을 제거 또는 감소
			compute(table[left++], '-');
			// scope 에 새로 추가된 초밥을 추가 또는 증가
			compute(table[right++], '+');
			// 쿠폰 초밥은 항상 있으므로 1로 고정
			map.put(c, 1);
			// 종류의 최댓값 계산
			ans = Math.max(map.size(), ans);
		}
		
		// 최댓값 출력
		System.out.println(ans);
	}
	private static void compute(int key, char ops) {
		switch(ops) {
			case '+':
				if(map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				} break;
			case '-':
				if(map.containsKey(key) && map.get(key) > 1) {
					map.put(key, map.get(key) - 1);
				} else {
					map.remove(key);
				} break;
		}
	}
}