import java.util.*;
import java.io.*;

public class Main {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] dr = {1,1}; // 5시 - 7시
	static int[] dc = {1,-1}; 
	static int[] n, e, w, s;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int range = 1;
		while(0 + range <= (N-1) - range) {
			simulate(range);
			range++;
		}
		System.out.println(ans);
	}
	
	private static void simulate(int range) {
		
		for (int i = 0 + range; i <= (N-1) - range; i++) {
			for (int j = 0 + range; j <= (N-1) - range; j++) {
				
				List<int[]> cases = divide(i,j, range); 
				
				for (int[] sums : cases) {
					int maxPopl = 0;
					int minPopl = Integer.MAX_VALUE;
					for (int p = 1; p <= 5; p++) {
						if(maxPopl < sums[p]) maxPopl = sums[p];
						if(minPopl > sums[p]) minPopl = sums[p];
					}
					ans = Math.min(ans, Math.abs(maxPopl - minPopl));
				}
				
			}
		}
	}
	private static ArrayList<int[]> divide(int r, int c, int range) {
		ArrayList<int[]> res = new ArrayList<>();
		int[] popl = new int[5+1];
		for (int d = 0; d < 2; d++) {
			boolean[][] divided = new boolean[N][N];
			int span = 0;
			int prev = 0;
			do {
				popl = new int[5+1];
				popl[5] = prev;
				int nr = r + dr[d]*span;
				int nc = c + dc[d]*span;
				if(!isInRange(nr,nc,range)) break;
				popl[5] += make5(nr,nc,divided, range);
				set5Bound(divided);
				popl[1] = make1(divided);
				popl[2] = make2(divided);
				popl[3] = make3(divided);
				popl[4] = make4(divided);
				res.add(popl);
				prev = popl[5];
				span++;
			} while (true);
		}
		
		return res;
	}

	private static boolean isInRange(int r, int c, int range) {
		return 0+range<=r&&r<=(N-1)-range && 0+range<=c&&c<=(N-1)-range;
	}
	
	private static void set5Bound(boolean[][] divided) {
		int minR, minC, maxR, maxC;
		minR = minC = Integer.MAX_VALUE;
		maxR = maxC = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <	N; j++) {
				if(divided[i][j]) {
					if(minR > i) minR = i;
					if(minC > j) minC = j;
					if(maxR < i) maxR = i;
					if(maxC < j) maxC = j;
				}
			}
		}
		n = new int[2];
		e = new int[2];
		w = new int[2];
		s = new int[2];
		for (int i = 0; i < N; i++) {
			if(divided[minR][i] == true) {
				n = new int[] {minR,i};
			}
			if(divided[maxR][i] == true) {
				s = new int[] {maxR,i};
			}
		}
		for (int i = 0; i < N; i++) {
			if(divided[i][minC] == true) {
				w = new int[] {i, minC};
			}
			if(divided[i][maxC] == true) {
				e = new int[] {i, maxC};
			}
		}
	}

	
	private static int make1(boolean[][] divided) {
		int cnt = 0;
		for (int i = 0; i <= w[0]-1; i++) {
			for (int j = 0; j <= n[1]; j++) {
				if(!divided[i][j]) {
					cnt+=map[i][j];
				}
			}
		}
		return cnt;
	}

	private static int make2(boolean[][] divided) {
		int cnt = 0;
		for (int i = 0; i <= e[0]; i++) {
			for (int j = n[1]+1; j <= N-1; j++) {
				if(!divided[i][j]) {
					cnt+=map[i][j];
				}
			}
		}
		return cnt;
	}

	private static int make3(boolean[][] divided) {
		int cnt = 0;
		for (int i = w[0]; i <= N-1; i++) {
			for (int j = 0; j <= s[1]-1; j++) {
				if(!divided[i][j]) {
					cnt+=map[i][j];
				}
			}
		}
		return cnt;
	}

	private static int make4(boolean[][] divided) {
		int cnt = 0;
		for (int i = e[0]+1; i <= N-1; i++) {
			for (int j = s[1]; j <= N-1; j++) {
				if(!divided[i][j]) {
					cnt+=map[i][j];
				}
			}
		}
		return cnt;
	}

	private static int make5(int r, int c, boolean[][] divided, int range) {
		int cnt = 0;
		for (int i = r-range; i <= r+range; i++) {
			for (int j = c-range; j <= c+range; j++) {
				if(!divided[i][j] && getDist(r,c,i,j) <= range) {
					divided[i][j] = true;
					cnt+=map[i][j];
				}
			}
		}
		return cnt;
	}

	private static int getDist(int r, int c, int i, int j) {
		return Math.abs(r-i) + Math.abs(c-j);
	}
}