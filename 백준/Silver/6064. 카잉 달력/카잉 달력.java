import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int T, M, N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve() {
        int result = -1;
        int num = x;
        while (num <= N * M) {
            int modX = (num % N == 0) ? N : num % N;
            int modY = (num % M == 0) ? M : num % M;

            if (modX == x && modY == y) {
                result = num;
                break;
            } else {
                num += N;
            }
        }
        return result;
    }
}