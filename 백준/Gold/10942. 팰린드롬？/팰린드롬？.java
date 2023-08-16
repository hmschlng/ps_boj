import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = init(N+1, arr);
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sj.add(String.valueOf(dp[from][to]));
        }
        System.out.println(sj);
    }

    private static int[][] init(int size, int[] arr) {
        int [][] dp = new int[size][size];

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }

                int left = i;
                int right = j;
                boolean isPalin = true;

                while(left <= right) {
                    if(arr[left++] != arr[right--]) {
                        isPalin = false;
                        break;
                    }

                }
                dp[i][j] = isPalin ? 1 : 0;
            }
        }

        return dp;
    }

}