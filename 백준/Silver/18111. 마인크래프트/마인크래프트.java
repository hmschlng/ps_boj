import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int[][] map;
	static PriorityQueue<Result> results;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				map[i][j] = h;
				maxHeight = Math.max(maxHeight, h);
			}
		}
		maxHeight++;

		results = new PriorityQueue<>((x,y) -> Integer.compare(x.t, y.t));
		while (maxHeight >= 0) {
			Result res = process(maxHeight--);
			if (res != null) {
				results.offer(res);
			}
		}

		System.out.println(results.peek().t + " " + results.peek().h);
	}

	// 해당 높이로 맞추고 그 결과흫 반환하는 함수
	private static Result process(int height) {
		int inven = B;
		int time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > height) {
					int amount = map[i][j] - height;
					inven += amount;
					time += amount * 2;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] < height) {
					int amount = height - map[i][j];
					inven -= amount;
					time += amount;
				}
				if(inven < 0) return null;
			}
		}
		return new Result(height, time);
	}

	static class Result {
		int h, t;

		public Result(int h, int t) {
			this.h = h;
			this.t = t;
		}
	}
}