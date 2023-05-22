import java.util.*;
import java.io.*;

public class Main {
	static int r,c;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];

		// 보드 입력 저장
		for (int i = 0; i < r; i++) {
			char[] colors = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				switch (colors[j]) {
					case 'B': board[i][j] = 1; break;
					case 'W': board[i][j] = 0; break;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		// 검사 시작
		for (int i = 0; i < r-7; i++) {
			for (int j = 0; j < c-7; j++) {
				int count = Math.min(checkBoard(i, j, 1), checkBoard(i, j, 0));
				min = Math.min(count, min);
			}
		}

		System.out.println(min);
	}

	private static int checkBoard(int r, int c, int first) {
		int[] color = (first == 1) ? new int[] {1,0} : new int[] {0,1};
		int mismatch1 = 0;
		for (int i = r; i < r + 8; i++) {
			for (int j = c + 1; j < c + 8; j += 2) {
				if(board[i][j - 1] != color[0]) mismatch1++;
				if(board[i][j] != color[1]) mismatch1++;
			}
			color = (color[0] == 1) ? new int[] {0,1} : new int[] {1,0};
		}

		return mismatch1;
	}
}