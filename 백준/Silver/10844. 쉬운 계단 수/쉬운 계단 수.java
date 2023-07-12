import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0) {
                    dp[i][0] = dp[i-1][1];
                }
                else if(j==9) {
                    dp[i][9] = dp[i-1][8];
                }
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }

        System.out.println(Arrays.stream(dp[N]).sum() % MOD);
    }
}