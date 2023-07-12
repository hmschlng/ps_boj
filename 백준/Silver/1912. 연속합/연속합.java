import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            ans = Math.max(ans, dp[i]);
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dp));

        System.out.println(ans);
    }
}