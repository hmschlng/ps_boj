import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static char[][] campus;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 상우하좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (campus[i][j] == 'I') {
                    start = new int[]{i, j};
                }
            }
        }

        v = new boolean[N][M];
        ans = 0;
        bfs(start);

        System.out.println(ans == 0 ? "TT" : ans);
    }

    private static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        v[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!isIn(nr, nc)) continue;
                if (v[nr][nc]) continue;
                if (campus[nr][nc] == 'X') continue;

                if(campus[nr][nc] == 'P') ans++;
                q.offer(new int[]{nr, nc});
                v[nr][nc] = true;
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return (0 <= r && r < N) && (0 <= c && c < M);
    }
}