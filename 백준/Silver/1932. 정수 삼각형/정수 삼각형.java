import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[][] tri, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tri = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        int max = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Math.max(dp[i-1][j-1] + tri[i][j], dp[i-1][j] + tri[i][j]);
                if(i == N) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}