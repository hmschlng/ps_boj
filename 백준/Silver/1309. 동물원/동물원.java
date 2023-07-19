import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        dp[0] = 1;
        if(N >= 1)
            dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            dp[i] = ((2 * dp[i-1]) % MOD + dp[i-2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}