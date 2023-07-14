import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int R, C, ans;
    static int[][] map, dp;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        dp = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        dfs(1, 1);
        System.out.println(dp[1][1]);
    }

    private static int dfs(int r, int c) {
        if (r == R && c == C)   {
            return 1;
        }
        if (dp[r][c] != -1)     return dp[r][c];

        dp[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d],
                nc = c + dc[d];

            if (isIn(nr, nc) && map[nr][nc] < map[r][c]) {
                dp[r][c] += dfs(nr, nc);
            }
        }

        return dp[r][c];
    }

    private static boolean isIn(int r, int c) {
        return 1 <= r && r <= R && 1 <= c && c <= C;
    }
}