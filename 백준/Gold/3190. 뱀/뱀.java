import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, K, L, dir, ans;
    static int[][] map;
    static boolean[][] v;
    static List<int[]> snake;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        v = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }
        ans = 0;

        snake = new ArrayList<>();
        snake.add(new int[]{1, 1});
        v[1][1] = true;
        dir = 1;
        L = Integer.parseInt(br.readLine());
        boolean isGameOver = false;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);

            isGameOver = move(X-ans);
            if (isGameOver) break;
            rotate(C);
        }
        if(!isGameOver) {
            move(101);
        }
        System.out.println(ans);
    }

    public static boolean move(int time) {
        int[] head = snake.get(snake.size() - 1);
        while (time --> 0) {
            ans++;

            int nr = head[0] + dr[dir];
            int nc = head[1] + dc[dir];

            if (!isIn(nr, nc)) return true;
            if (v[nr][nc]) return true;

            head = new int[]{nr, nc};
            snake.add(head);
            v[nr][nc] = true;

            if (map[nr][nc] != 1) {
                int[] tail = snake.get(0);
                v[tail[0]][tail[1]] = false;
                snake.remove(0);
            } else {
                map[nr][nc] = 0;
            }
        }
        return false;
    }

    private static void rotate(char cmd) {
        if (cmd == 'L') {
            dir = (dir == 0) ? 3 : dir - 1;
            return;
        }
        dir = (dir + 1) % 4;
    }

    private static boolean isIn(int r, int c) {
        return 1 <= r && r <= N && 1 <= c && c <= N;
    }
}