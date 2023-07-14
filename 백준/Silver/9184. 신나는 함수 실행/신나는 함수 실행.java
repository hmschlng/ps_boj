import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][][] dp;
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        init(20,20,20);

        while (true) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (A == -1 && B == -1 && C == -1) break;

            sb.append("w(").append(A)
                    .append(", ").append(B)
                    .append(", ").append(C)
                    .append(") = ").append(w(A, B, C)).append("\n");
        }

        System.out.print(sb);
    }

    private static void init(int A, int B, int C) {
        dp = new int[A + 1][B + 1][C + 1];
    }

    private static int w(int a, int b, int c) {
        if (isIn(a,b,c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20,20,20);
        }
        else if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else {
            return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }
    
    private static boolean isIn(int a, int b, int c) {
        return (0 <= a && a <= 20) && (0 <= b && b <= 20) && (0 <= c && c <= 20);
    }
}