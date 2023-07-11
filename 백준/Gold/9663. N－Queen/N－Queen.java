import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static boolean[][] board;
    // 1 -> 5 -> 7 -> 11
    static int[] dr = {-1, 1, 1, -1}, dc = {1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            board = new boolean[N][N];
            board[0][i] = true;
            process(1, 0, i);
            board[0][i] = false;
        }
        System.out.println(ans);
    }

    private static void process(int cnt, int r, int c) {
        if (!canSurvive(r, c)) {
            board[r][c] = false;
        } else {
            if (r == N - 1) {
                ans++;
                return;
            }
            for (int i = 0; i < N; i++) {
                if (i == c) continue;
                board[r + 1][i] = true;
                process(cnt + 1, r + 1, i);
                board[r + 1][i] = false;
            }
        }
    }

    private static boolean canSurvive(int r, int c) {
        for (int i = 0; i < N; i++) {
            if ((i != c && board[r][i]) || (i != r && board[i][c]))
                return false;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            while (isIn(nr, nc)) {
                nr += dr[d];
                nc += dc[d];
                if (!isIn(nr, nc)) break;
                if (board[nr][nc]) return false;
            }
        }
        return true;
    }

    private static boolean isIn(int r, int c) {
        return (0 <= r && r < N) && (0 <= c && c < N);
    }
}