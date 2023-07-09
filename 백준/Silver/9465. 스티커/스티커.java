import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[][] board;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while(T--> 0) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            board = new int[2][N+1];

            for (int i = 1; i <= N; i++) {
                board[0][i] = Integer.parseInt(st1.nextToken());
                board[1][i] = Integer.parseInt(st2.nextToken());
            }

            dp = new int[2][N+1];
            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];

            for (int i = 2; i <= N; i++) {
                dp[0][i] = board[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = board[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.print(sb);
    }
}