import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final long MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];

        dp[1][0] = 1;
        if(K >= 1)
            dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= K; j++) {
                if(j > i) break;
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}