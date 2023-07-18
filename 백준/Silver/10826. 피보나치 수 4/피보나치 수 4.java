import java.io.*;
import java.math.BigDecimal;

public class Main {
    static BigDecimal[][] matrix = new BigDecimal[][] {
            {new BigDecimal(1), new BigDecimal(1)},
            {new BigDecimal(1), new BigDecimal(0)}};

    static BigDecimal[] base = new BigDecimal[] {new BigDecimal(1), new BigDecimal(1)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());


        if(N == 0)
            System.out.println(0);
        else if(N == 1)
            System.out.println(1);
        else if (N == 2)
            System.out.println(1);
        else {
            BigDecimal[] ans = mul(getPow(matrix, N - 2), base);

            System.out.println(ans[0].toString());
        }
    }

    private static BigDecimal[][] getPow(BigDecimal[][] matrix, long pow) {
        if(pow == 1) {
            return matrix;
        }
        else {
            if(pow % 2 == 0) {
                BigDecimal[][] part = getPow(matrix, pow/2);
                return mul(part, part);
            }
            else {
                return mul(getPow(matrix, pow-1), matrix);
            }
        }
    }

    private static BigDecimal[][] mul(BigDecimal[][] m, BigDecimal[][] n) {
        BigDecimal[][] res = new BigDecimal[2][2];
        res[0][0] = getVal(m[0][0], n[0][0], m[0][1], n[1][0]);
        res[0][1] = getVal(m[0][0], n[0][1], m[0][1], n[1][1]);
        res[1][0] = getVal(m[1][0], n[0][0], m[1][1], n[1][0]);
        res[1][1] = getVal(m[1][0], n[0][1], m[1][1], n[1][1]);
        return res;
    }

    private static BigDecimal[] mul(BigDecimal[][] m, BigDecimal[] n) {
        BigDecimal[] res = new BigDecimal[2];
        res[0] = getVal(m[0][0], n[0], m[0][1], n[1]);
        res[1] = getVal(m[1][0], n[0], m[1][1], n[1]);
        return res;
    }

    private static BigDecimal getVal(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return a.multiply(b).add(c.multiply(d));
    }
}