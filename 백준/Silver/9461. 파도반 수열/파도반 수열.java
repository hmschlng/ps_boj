import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T, N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        init();

        while (T-->0) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }

    private static void init() {
        dp = new long[100 + 1];
        for (int i = 1; i <= 3; i++) {
            dp[i] = 1;
        }
        for (int i = 4; i <= 100; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }
    }
}