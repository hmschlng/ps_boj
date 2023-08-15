import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] liquids;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		liquids = new long[N];
		for (int i = 0; i < N; i++) {
			liquids[i] = Long.parseLong(st.nextToken());
		}

		long[] ans = new long[2];
		long min = Integer.MAX_VALUE;
		int left = 0, right = N-1;
		while(left < right) {
			long sum = liquids[left] + liquids[right];
			if(Math.abs(sum) <= min) {
				ans[0] = liquids[left];
				ans[1] = liquids[right];
				min = Math.abs(sum);
			}
			if(sum < 0) {
				left++;
			}
			else {
				right--;
			}
		}

		Arrays.sort(ans);
		System.out.println(ans[0] + " " + ans[1]);
	}
}