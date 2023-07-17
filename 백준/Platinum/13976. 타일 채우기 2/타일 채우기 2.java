import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;
    static long[][] matrix;
    static long[] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if(N % 2 == 1)
            System.out.println(0);
        else if (N == 2)
            System.out.println(3);
        else {
            matrix = new long[][]{
                    {4, -1},
                    {1, 0}};
            base = new long[]{
                    3,
                    1
            };

            long[][] powered = getPowerOfMatrix(matrix, (N-2)/2);
            long[] ans = multiplyMatrix(powered, base);

            System.out.println(ans[0]);
        }
    }

    private static long[][] getPowerOfMatrix(long[][] matrix, long pow) {
        if(pow == 1) return matrix;

        if(pow % 2 == 0) {
            long[][] half = getPowerOfMatrix(matrix, pow/2);
            return multiplyMatrix(half, half);
        }
        long[][] even = getPowerOfMatrix(matrix, pow-1);
        return multiplyMatrix(even, matrix);
    }

    private static long[][] multiplyMatrix(long[][] m1, long[][] m2) {
        long[][] res = new long[2][2];
        res[0][0] = getValue(m1[0][0],m2[0][0], m1[0][1], m2[1][0]);
        res[0][1] = getValue(m1[0][0],m2[0][1], m1[0][1], m2[1][1]);
        res[1][0] = getValue(m1[1][0],m2[0][0], m1[1][1], m2[1][0]);
        res[1][1] = getValue(m1[1][0],m2[0][1], m1[1][1], m2[1][1]);

        return res;
    }

    private static long[] multiplyMatrix(long[][] m1, long[] m2) {
        long[] res = new long[2];
        res[0] = getValue(m1[0][0],m2[0], m1[0][1], m2[1]);
        res[1] = getValue(m1[1][0],m2[0], m1[1][1], m2[1]);

        return res;
    }

    private static long getValue(long a, long b, long c, long d) {
        return ((a * b % MOD) + (c * d % MOD) + MOD) % MOD;
    }
}

/* 행렬을 이용한 DP

    1. 점화식 형태로 나타내기
    dp[0] = 1
    dp[2] = 3
    dp[4] = dp[2] * 3 + dp[0] * 2
    dp[6] = dp[4] * 3 + dp[2] * 2 + dp[0] * 2
    dp[8] = dp[6] * 3 + dp[4] * 2 + dp[2] * 2 + dp[0] * 2

    이때
    dp[6]           =   dp[4] * 3 + dp[2] * 2 + dp[0] * 2
                    =   dp[4] * 2 + dp[2] * 2 + dp[0] * 2 + dp[4]
    dp[6] - dp[4]   =   dp[4] * 2 + dp[2] * 2 + dp[0] * 2
    dp[8] = dp[6] * 3 + dp[4] * 2 + dp[2] * 2 + dp[0] * 2
          = dp[6] * 3 + dp[6] - dp[4]
          = dp[6] * 4 - dp[4]

    ∴ dp[n] = dp[n-2] * 4 - dp[n-4] 이다.

    2. 행렬식으로 표현하기
    dp[4] = 4 * dp[2] - 1 * dp[0]
    dp[2] = 1 * dp[2] - 0 * 0

    ┌ dp[4] ┐  =>   ┌ 4, -1 ┐  *  ┌ dp[2] ┐
    └ dp[2] ┘       └ 1,  0 ┘     └ dp[0] ┘

    ┌ dp[6] ┐  =>   ┌ 4, -1 ┐  *  ┌ dp[4] ┐
    └ dp[4] ┘       └ 1,  0 ┘     └ dp[2] ┘
               =>   ┌ 4, -1 ┐  *  ┌ 4, -1 ┐  *  ┌ dp[2] ┐
                    └ 1,  0 ┘     └ 1,  0 ┘     └ dp[0] ┘
               =>   ┌ 4, -1 ┐² *  ┌ dp[2] ┐
                    └ 1,  0 ┘     └ dp[0] ┘

    ┌ dp[8] ┐  =>   ┌ 4, -1 ┐  *  ┌ dp[6] ┐
    └ dp[6] ┘       └ 1,  0 ┘     └ dp[4] ┘
               =>   ┌ 4, -1 ┐  *  ┌ 4, -1 ┐  *  ┌ 4, -1 ┐  *  ┌ dp[2] ┐
                    └ 1,  0 ┘     └ 1,  0 ┘     └ 1,  0 ┘     └ dp[0] ┘
               =>   ┌ 4, -1 ┐³ *  ┌ dp[2] ┐
                    └ 1,  0 ┘     └ dp[0] ┘

    ∴ 일반식
    ┌ dp[n]   ┐  =>   ┌ 4, -1 ┐(n-2)/2  *  ┌ 3 ┐
    └ dp[n-2] ┘       └ 1,  0 ┘            └ 1 ┘


    3. 정리
    dp[n]을 구하려면 ┌ dp[n]   ┐ 행렬을 구하면 되고,
                   └ dp[n-2] ┘

    이 행렬을 구하려면 ┌ 4, -1 ┐(n-2)/2  *  ┌ 3 ┐ 을 계산해야 하니,
                     └ 1,  0 ┘            └ 1 ┘

    입력받은 N에서 (N-2)/2 값을 구한 뒤 계산을 해주면 답을 찾을 수 있다.
*/