import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> squares;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        init();

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < squares.size(); j++) {
                if(i - squares.get(j) < 0) break;
                min = Math.min(min, dp[i - squares.get(j)]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[N]);
    }

    private static void init() {
        squares = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(50000); i++) {
            if (i * i <= 50000) {
                squares.add(i * i);
            }
        }
        dp = new int[N + 1];
        dp[1] = 1;
    }
}