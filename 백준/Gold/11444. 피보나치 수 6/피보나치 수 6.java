import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007;
    static long[][] matrix = {{1, 1}, {1, 0}};
    static long[] base = {1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if(N == 1) System.out.println(1);
        else if (N==2) System.out.println(1);
        else {
            long[] ans = multiply(getPower(matrix, N-2), base);
    
            System.out.println(ans[0]);
        }
    }
    
    private static long[][] getPower(long[][] matrix, long pow) {
        if(pow == 1) return matrix;
        
        if(pow %2 == 0) {
            long[][] part = getPower(matrix, pow/2);
            return multiply(part, part);
        }
        return multiply(getPower(matrix, pow-1), matrix);
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = getValue(a[0][0], b[0][0],a[0][1], b[1][0]); 
        res[0][1] = getValue(a[0][0], b[0][1],a[0][1], b[1][1]); 
        res[1][0] = getValue(a[1][0], b[0][0],a[1][1], b[1][0]); 
        res[1][1] = getValue(a[1][0], b[0][1],a[1][1], b[1][1]);
        return res;
    }
    private static long[] multiply(long[][] a, long[] b) {
        long[] res = new long[2];
        res[0] = getValue(a[0][0], b[0], a[0][1], b[1]);
        res[1] = getValue(a[1][0], b[0], a[1][1], b[1]);
        return res;
    }
    
    private static long getValue(long a, long b, long c, long d) {
        return ((a * b) % MOD + (c * d) % MOD) % MOD;
    }
}