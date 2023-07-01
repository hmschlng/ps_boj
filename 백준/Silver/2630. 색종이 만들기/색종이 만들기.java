import java.io.*;
import java.util.*;

public class Main {
	static int[][] sheet;
	static int[] start, end, ans = new int[2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		sheet = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sheet[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new int[] { 0, 0 };
		end = new int[] { N, N };
		
		cut(start, end, N);
		
		System.out.println(ans[0] + "\n" + ans[1]);
	}

	private static void cut(int[] start, int[] end, int scale) {
		if(start[0] > end[0] && start[1] > end[1]) return;

		int color = isMonoColored(start, end);
		
		if (color >= 0) {
			ans[color]++;
			return;
		}
		else {
			scale /= 2;
			cut(new int[] { start[0], start[1] }, 
					new int[] { end[0] - scale, end[1] - scale }, scale);
			
			cut(new int[] { start[0], start[1] + scale }, 
					new int[] { end[0] - scale, end[1] }, scale);
			
			cut(new int[] { start[0] + scale, start[1] }, 
					new int[] { end[0], end[1] - scale }, scale);
			
			cut(new int[] { start[0] + scale, start[1] + scale },
					new int[] { end[0], end[1] }, scale);
		}
	}

	static int isMonoColored(int[] start, int[] end) {
		int color = sheet[start[0]][start[1]];
		for (int i = start[0]; i < end[0]; i++) {
			for (int j = start[1]; j < end[1]; j++) {
				if (sheet[i][j] != color) {
					return -1;
				}
			}
		}
		return color;
	}
}