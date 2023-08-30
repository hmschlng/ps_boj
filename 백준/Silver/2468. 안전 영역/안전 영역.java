import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE, max = 0;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int ans = 0;
        for(int h = min - 1; h < max; h++) {
            v = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(v[i][j]) continue;
                    if(map[i][j] <= h) continue;
                    bfs(new int[]{i,j}, h);
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
//            System.out.println(h + " -> " + cnt);
//            for(boolean[] a : v) {
//                for(boolean b : a) {
//                    System.out.print(b ? "*" : " ");
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.println(ans);
    }

    public static void bfs(int[] src, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(src);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(v[cur[0]][cur[1]]) continue;
            v[cur[0]][cur[1]] = true;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if(!isIn(nr, nc)) continue;
                if(v[nr][nc]) continue;
                if(map[nr][nc] <= h) continue;

                q.offer(new int[]{nr, nc});
            }
        }
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}