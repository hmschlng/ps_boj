import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long ans = pow(A, B, C);
        
        System.out.println(ans);
    }

    private static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long divide = pow(A, B / 2, C);

        return (B % 2 == 0) ?
            (divide * divide % C) :
            ((divide * divide % C) * A % C);
    }
}