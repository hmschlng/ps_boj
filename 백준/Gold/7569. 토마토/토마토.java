import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, H, fresh, ans;
    static int[][][] silo;
    static boolean[][][] v;
    static Queue<int[]> q;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}, dh = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        silo = new int[H][N][M];
        v = new boolean[H][N][M];
        q = new ArrayDeque<>();
        fresh = 0;
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    silo[h][r][c] = Integer.parseInt(st.nextToken());
                    switch (silo[h][r][c]) {
                        case 0:
                            fresh++;
                            break;
                        case 1:
                            q.offer(new int[]{h, r, c, 0});
                            v[h][r][c] = true;
                            break;
                    }
                }
            }
        }

        ans = 0;
        bfs(); // 토마토 익히기

        System.out.println((fresh != 0) ? -1 : ans); // 익힐 수 없는 토마토가 있는 경우 -1
    }

    private static void bfs() {
        // 익힐 토마토가 없는 경우
        if (fresh == 0) return;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ans = Math.max(cur[3], ans);

            // 전우후좌
            for (int d = 0; d < 4; d++) {
                int nr = cur[1] + dr[d];
                int nc = cur[2] + dc[d];

                if (!isIn(cur[0], nr, nc)) continue;
                if (v[cur[0]][nr][nc]) continue;
                if(silo[cur[0]][nr][nc] != 0) continue;

                silo[cur[0]][nr][nc] = 1;
                fresh--;
                v[cur[0]][nr][nc] = true;
                q.offer(new int[]{cur[0],nr,nc,cur[3]+1});
            }
            // 상하
            for (int h = 0; h < 2; h++) {
                int nh = cur[0] + dh[h];

                if(!isIn(nh, cur[1], cur[2])) continue;
                if(v[nh][cur[1]][cur[2]]) continue;
                if(silo[nh][cur[1]][cur[2]] != 0) continue;

                silo[nh][cur[1]][cur[2]] = 1;
                fresh--;
                v[nh][cur[1]][cur[2]] = true;
                q.offer(new int[]{nh, cur[1], cur[2], cur[3] + 1});
            }
        }
    }

    private static boolean isIn(int h, int r, int c) {
        return (0 <= h && h < H) && (0 <= r && r < N) && (0 <= c && c < M);
    }

}