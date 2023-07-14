import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}