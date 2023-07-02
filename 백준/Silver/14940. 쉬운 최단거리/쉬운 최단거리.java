import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static int[][] map, ans;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, src;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    src = new int[]{i, j};
                }
            }
        }

        v = new boolean[N][M];
        bfs(src);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[] src) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src[0], src[1], 0});
        v[src[0]][src[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ans[cur[0]][cur[1]] = cur[2];

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!isIn(nr, nc)) continue;
                if(map[nr][nc] == 0) continue;
                if (v[nr][nc]) continue;

                v[nr][nc] = true;

                q.offer(new int[] {nr, nc, cur[2] + 1});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(v[i][j]) continue;
                if(map[i][j] == 1 && ans[i][j] == 0) ans[i][j] = -1;
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return (0 <= r && r < N) && (0 <= c && c < M);
    }
}