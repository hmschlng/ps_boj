import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int N, K, ans;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[10];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        ans = 0;
        while (K > 0) {
            if (K / coins[idx] > 0) {
                ans += K / coins[idx];
                K %= coins[idx];
            }
            idx++;
        }

        System.out.println(ans);
    }
}