import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Info[] infos;
	static PriorityQueue<Info> res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		infos = new Info[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
			infos[i] = new Info(i,w,h);
		}


		res = new PriorityQueue<>((x,y) -> Integer.compare(x.idx, y.idx));
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(isBigger(infos[j], infos[i])) {
					cnt++;
				}
			}
			infos[i].rank = cnt + 1;
			res.offer(infos[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(res.poll().rank + " ");
		}

		System.out.print(sb);
	}
	private static boolean isBigger(Info x, Info y) {
		return x.weight > y.weight && x.height > y.height;
	}
	static class Info {
		int idx, weight, height, rank;

		public Info(int idx, int weight, int height) {
			this.idx = idx;
			this.weight = weight;
			this.height = height;
			this.rank = 0;
		}
	}

}