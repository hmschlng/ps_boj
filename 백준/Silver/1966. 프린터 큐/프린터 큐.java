import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.Doc;

public class Main {
	static int T,N,M;
	static Queue<Doc> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			q = new ArrayDeque<>();
			List<Integer> wList = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				wList.add(w);
				q.add(new Doc(w, j));
			}

			Collections.sort(wList, Collections.reverseOrder());

			int res = 0;
			while(true) {
				Doc d = q.poll();
				if(d.w == wList.get(0)) {
					res++;
					if(d.num == M) {
						break;
					}
					wList.remove(0);
				} else {
					q.offer(d);
				}
			}

			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}
	static class Doc {
		int w,num;

		public Doc(int w, int num) {
			this.w = w;
			this.num = num;
		}
	}
}