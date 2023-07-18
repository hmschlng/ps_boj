import java.io.*;
import java.util.*;

public class Main {
    static long[][] matrix = {{1, 1}, {1, 0}};
    static long[] base = {1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(N == 1)
            System.out.println(1);
        else if (N == 2)
            System.out.println(1);
        else {
            long[] ans = mul(getPow(matrix, N - 2), base);

            System.out.println(ans[0]);
        }
    }

    private static long[][] getPow(long[][] matrix, long pow) {
        if(pow == 1) {
            return matrix;
        }
        else {
            if(pow % 2 == 0) {
                long[][] part = getPow(matrix, pow/2);
                return mul(part, part);
            }
            else {
                return mul(getPow(matrix, pow-1), matrix);
            }
        }
    }

    private static long[][] mul(long[][] m, long[][] n) {
        long[][] res = new long[2][2];
        res[0][0] = getVal(m[0][0], n[0][0], m[0][1], n[1][0]);
        res[0][1] = getVal(m[0][0], n[0][1], m[0][1], n[1][1]);
        res[1][0] = getVal(m[1][0], n[0][0], m[1][1], n[1][0]);
        res[1][1] = getVal(m[1][0], n[0][1], m[1][1], n[1][1]);
        return res;
    }

    private static long[] mul(long[][] m, long[] n) {
        long[] res = new long[2];
        res[0] = getVal(m[0][0], n[0], m[0][1], n[1]);
        res[1] = getVal(m[1][0], n[0], m[1][1], n[1]);
        return res;
    }

    private static long getVal(long a, long b, long c, long d) {
        return (a * b) + (c * d);
    }
}