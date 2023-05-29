import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static PriorityQueue<Point> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		pq = new PriorityQueue<>((p1,p2) -> {
			if(p1.y == p2.y) {
				return Integer.compare(p1.x, p2.x);
			}
			else {
				return Integer.compare(p1.y, p2.y);
			}
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Point p = pq.poll();
			sb.append(p.x + " " + p.y + "\n");
		}

		System.out.println(sb);
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}