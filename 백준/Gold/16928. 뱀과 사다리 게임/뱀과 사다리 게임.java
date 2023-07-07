import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int ladder, snake, ans;
    static int[] board;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        board = new int[100 + 1];
        ladder = Integer.parseInt(st.nextToken());
        snake = Integer.parseInt(st.nextToken());
        for (int i = 0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }

        v = new boolean[100 + 1];
        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        v[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == 100) {
                ans = cur[1];
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nc = cur[0] + i;
                if(!isIn(nc)) continue;
                if(v[nc]) continue;

                v[nc] = true;
                if(board[nc] != 0) {
                    nc = board[nc];
                    v[nc] = true;
                }
                q.offer(new int[] {nc, cur[1] + 1});
            }
        }
    }

    private static boolean isIn(int idx) {
        return 1 <= idx && idx <= 100;
    }
}