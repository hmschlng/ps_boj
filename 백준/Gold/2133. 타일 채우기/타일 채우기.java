import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        if(N >= 2)
            dp[2] = 3;

        for (int i = 4; i <= N; i+=2) {
            dp[i] = (dp[i-2] * 3) + 2;
            if(i >= 6) {
                for (int j = 2; j <= i-4; j+=2) {
                    dp[i] += (dp[j] * 2);
                }
            }
        }

        System.out.println(dp[N]);
    }
}