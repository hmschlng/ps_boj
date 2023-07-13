import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 10007;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10 + 1];
        Arrays.fill(dp[1], 1, 10 + 1, 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(Arrays.stream(dp[N]).sum() % MOD);
    }
}