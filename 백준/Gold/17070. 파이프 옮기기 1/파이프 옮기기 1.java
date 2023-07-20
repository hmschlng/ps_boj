import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, ans;
    static Pipe[][] map;
    static boolean[][] v;
    static int[][][] dr = {{{0}, {}, {0, 1, 1}}, {{}, {1}, {0, 1, 1}}, {{0}, {1}, {0, 1, 1}}};
    static int[][][] dc = {{{1}, {}, {1, 0, 1}}, {{}, {0}, {1, 0, 1}}, {{1}, {0}, {1, 0, 1}}};
    static int[][] mr = {{0, -1, 1}, {-1, 1, 1}, {0, 1, 1}};
    static int[][] mc = {{1, -1, 1}, {-1, 0, 1}, {1, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new Pipe[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    map[i][j] = new Pipe(i, j, true);
                }
                else {
                    map[i][j] = new Pipe(i, j, false);
                }
            }
        }
        // 방향 초기 세팅 (가로, 세로, 대각선)
        map[1][2].dir = new boolean[]{true, false, false};
        ans = 0;
        v = new boolean[N+1][N+1];
        dfs(1,2);
        System.out.println(ans);
    }
    private static void dfs(int r, int c) {
        if(r == N && c == N) {
            ans++;
            return;
        }
        Pipe cur = map[r][c];
        for (int dir = 0; dir < 3; dir++) {
            if(!cur.dir[dir]) continue;

            for (int d = 0; d < dr[dir].length; d++) {
                if(dr[dir][d].length == 0) continue;
                boolean canGo = true;
                for (int i = 0; i < dr[dir][d].length; i++) {
                    int nr = cur.r + dr[dir][d][i];
                    int nc = cur.c + dc[dir][d][i];
                    if(!isIn(nr, nc)) {
                        canGo = false;
                        continue;
                    }
                    if(map[nr][nc].isWall) {
                        canGo = false;
                    }
                }
                if(!canGo) continue;
                int nr = cur.r + mr[dir][d];
                int nc = cur.c + mc[dir][d];

                map[nr][nc].dir[d] = true;
                dfs(nr, nc);
                map[nr][nc].dir[d] = false;
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return (1 <= r && r <= N) && (1 <= c && c <= N);
    }

}

class Pipe {
    boolean[] dir;
    int r, c, val;
    boolean isWall;

    public Pipe(int r, int c, boolean isWall) {
        this.dir = new boolean[3];
        this.r = r;
        this.c = c;
        this.val = 0;
        this.isWall = isWall;
    }
}