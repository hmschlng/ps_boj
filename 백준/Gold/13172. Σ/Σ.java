import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long M = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long Ni = Integer.parseInt(st.nextToken()); // N면체 주사위
            long Si = Integer.parseInt(st.nextToken()); // 주사위 모든 면의 값의 총합

            // a * b^(x-2) % x 형태의 식으로 나타낸 뒤 ans 에 합산
            long formula = (Si * getPow(Ni, MOD-2)) % MOD;
            ans = (ans + formula) % MOD;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }

    private static long getPow(long num, long pow) {
        if(pow == 1) {
            return num;
        }
        if(pow % 2 == 0) {
            long part = getPow(num, pow/2);
            return (part * part) % MOD;
        }
        return (getPow(num, pow-1) * num) % MOD;
    }

}