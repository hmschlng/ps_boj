import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line[j - 1] - '0';
            }
        }

        v = new boolean[N + 1][M + 1];
        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 1, 1});
        v[1][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == N && cur[1] == M) {
                ans = cur[2];
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!isIn(nr, nc)) continue;
                if (v[nr][nc]) continue;
                if (map[nr][nc] != 1) continue;

                q.offer(new int[]{nr, nc, cur[2] + 1});
                v[nr][nc] = true;
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return (0 < r && r <= N) && (0 < c && c <= M);
    }
}