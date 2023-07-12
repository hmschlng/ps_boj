import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] wines, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        wines = new int[N+1];
        dp = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = wines[1];
        if(N >= 2) {
            dp[2] = wines[1] + wines[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Arrays.stream(new int[] {
                dp[i-1],                        // O O X
                dp[i-2] + wines[i],             // O X O
                dp[i-3] + wines[i-1] + wines[i] // X O O
            }).max().getAsInt();
        }

        System.out.println(dp[N]);
    }
}