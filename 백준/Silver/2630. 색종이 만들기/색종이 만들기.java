import java.io.*;
import java.util.*;

public class Main {
    static int N, BLUE = 1, WHITE = 0;
    static int[] ans;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = new int[2];
        cut(new int[]{0, 0}, N);

        System.out.println(ans[0] + "\n" + ans[1]);
    }

    private static void cut(int[] start, int len) {
        if (len == 0) return;

        int color = isMono(start, len);

        if (color == BLUE || color == WHITE) {
            ans[color]++;
            return;
        }

        // 1
        cut(start, len / 2);
        // 2
        cut(new int[]{start[0], start[1] + len / 2}, len / 2);
        // 3
        cut(new int[]{start[0] + len / 2, start[1]}, len / 2);
        // 4
        cut(new int[]{start[0] + len / 2, start[1] + len / 2}, len / 2);
    }

    private static int isMono(int[] start, int len) {

        int color = paper[start[0]][start[1]];

        for (int i = start[0]; i < start[0] + len; i++) {
            for (int j = start[1]; j < start[1] + len; j++) {
                if (paper[i][j] != color) return -1;
            }
        }

        return (color == BLUE) ? BLUE : WHITE;
    }
}