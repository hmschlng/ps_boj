import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N + 1];
        dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

        System.out.println(dp[K]);
    }
}