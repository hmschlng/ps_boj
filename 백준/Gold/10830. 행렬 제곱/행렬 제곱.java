import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000;
    static StringTokenizer st;

    static int N;
    static long B;
    static long[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken());
                if(B == 1) {
                    matrix[i][j] %= MOD;
                }
            }
        }

        long[][] res = getPower(matrix, B);

        StringJoiner sj1 = new StringJoiner("\n");
        for (int i = 0; i < N; i++) {
            StringJoiner sj2 = new StringJoiner(" ");
            for (int j = 0; j < N; j++) {
                sj2.add(String.valueOf(res[i][j]));
            }
            sj1.add(sj2.toString());
        }
        System.out.println(sj1);
    }

    private static long[][] getPower(long[][] matrix, long pow) {
        if(pow == 1) return matrix;

        if(pow % 2 == 0) {
            long[][] part = getPower(matrix, pow/2);
            return multiply(part, part);
        }
        else {
            return multiply(getPower(matrix, pow-1), matrix);
        }
    }

    private static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] res = new long[N][N];

        for (int i = 0; i < N; i++) {
            long[] hor = m1[i];
            for (int j = 0; j < N; j++) {
                long[] vert = new long[N];
                for (int k = 0; k < N; k++) {
                    vert[k] = m2[k][j];
                }
                res[i][j] = multiply(hor, vert);
            }

        }
        return res;
    }

    private static long multiply(long[] m1, long[] m2) {
        long res = 0;
        for (int i = 0; i < N; i++) {
            res = (res + ((m1[i] * m2[i]) % MOD)) % MOD;
        }
        return res;
    }

}