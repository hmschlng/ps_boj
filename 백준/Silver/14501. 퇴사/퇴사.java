import java.io.*;
import java.util.*;

public class Main {
    static final int TIME = 0, PROFIT = 1;
    static StringTokenizer st;
    static int[] time, profit;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        profit = new int[N+1];

        // 거꾸로 저장
        for (int i = N; i >= 1; i--) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            // 퇴사일 이전에 할 수 없는 일인 경우 선택하지 않음
            if(time[i] > i) {
                dp[i] = dp[i-1];
            } 
            // 퇴사일 이전에 할 수 있는 일이면
            else {
                dp[i] = Math.max(
                        profit[i] + dp[i-time[i]],  // 선택하는 경우 -> 그 일의 상담소요일 이전 날짜까지의 금액 최대값 +  현재 금액 
                        dp[i-1]                     // 선택하지 않는 경우 -> 이전 일까지의 금액 최대값
                );
            }
        }
        System.out.println(dp[N]);
    }
}