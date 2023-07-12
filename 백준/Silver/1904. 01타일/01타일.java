import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] dp;
    static final long MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][2];

        dp[1] = new long[]{0, 1};
        if (N >= 2) {
            dp[2] = new long[]{1, 1};
        }
        
        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println((dp[N][0] + dp[N][1]) % MOD);
    }
}