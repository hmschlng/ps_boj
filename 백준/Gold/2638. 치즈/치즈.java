import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M, ans;
    static int[][] map, v;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        ans = 0;
        while (cnt != 0) {
            v = new int[N][M];
            int melted = bfs();
            cnt -= melted;
            ans++;
        }

        System.out.println(ans);
    }

    private static int bfs() {
        List<int[]> meltedList = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        v[0][0] = -1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(!isIn(nr, nc)) continue;
                if(v[nr][nc] == -1 || v[nr][nc] == 2) continue;
                if(map[nr][nc] == 1) {
                    switch(v[nr][nc]) {
                        case 1:
                            v[nr][nc]++;
                            meltedList.add(new int[]{nr,nc});
                            continue;
                        case 0:
                            v[nr][nc]++;
                            continue;
                    }
                }
                q.offer(new int[]{nr, nc});
                v[nr][nc] = -1;
            }
        }

        int cnt = meltedList.size();

        for(int[] c : meltedList) {
            map[c[0]][c[1]] = 0;
        }
        return cnt;
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}