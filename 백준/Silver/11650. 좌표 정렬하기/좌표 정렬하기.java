import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}
		Collections.sort(points, (x,y) -> {
			if(x.x == y.x) {
				return Integer.compare(x.y, y.y);
			}
			else return Integer.compare(x.x, y.x);
		});
		StringBuilder sb = new StringBuilder();
		for (Point p : points) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.print(sb);
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}