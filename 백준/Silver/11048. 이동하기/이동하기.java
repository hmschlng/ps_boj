import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Arrays.stream(new int[]{
                        dp[i - 1][j],
                        dp[i][j - 1],
                        dp[i - 1][j - 1]
                }).max().getAsInt() + map[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}