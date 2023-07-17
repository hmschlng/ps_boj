import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[2][N + 1];

        dp[0][0] = 1;
        dp[0][1] = 2;
        if (N >= 2)
            dp[0][2] = 7;

        for (int n = 3; n <= N; n++) {
            long A = 2*dp[0][n-1] + 3*dp[0][n-2];
            long B = dp[0][n-3] + dp[1][n-1];
            dp[0][n] = (A + (B * 2)) % MOD;
            dp[1][n] = B;
        }

        System.out.println(dp[0][N]);
    }
}