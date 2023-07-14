import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final long INF = 999_999_999L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        long[] dp = new long[K+1];
        for (int i = 1; i <= N; i++) {
            if(coins[i] <= K) {
                coins[i] = Integer.parseInt(br.readLine());
            }
        }

        Arrays.sort(coins);

        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                long A = dp[j-coins[i]];
                dp[j] = Math.min(A+1, dp[j]);
            }
        }
        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}