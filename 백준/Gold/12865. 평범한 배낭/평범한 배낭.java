import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++) {
                int A = 0, B = 0, C = dp[i - 1][j];
                if (j - w > 0) A = dp[i - 1][j - w];
                if (w <= j) B = v;
                dp[i][j] = Math.max(A + B, C);
            }
        }
        System.out.println(dp[N][K]);
    }
}