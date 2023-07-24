import java.io.*;
import java.util.*;

public class Main {
    static int N,M, flipCnt;
    static boolean[][] m1, m2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        m1 = new boolean[N][M];
        m2 = new boolean[N][M];

        for (int i = 0; i < N*2; i++) {
            char[] line = br.readLine().toCharArray();
            if(i >= N) {
                for (int j = 0; j < M; j++) {
                    m2[i-N][j] = (line[j] == '1') ? true : false;
                }
            } else {
                for (int j = 0; j < M; j++) {
                    m1[i][j] = (line[j] == '1') ? true : false;
                }
            }
        }

        flipCnt = 0;
        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <= M-3; j++) {
                if(m1[i][j] != m2[i][j]) {
                    flipM1(i,j);
                    flipCnt++;
                }
            }
        }

        boolean isEqual = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(m1[i][j] != m2[i][j]) isEqual = false;
            }
        }

        System.out.println(isEqual ? flipCnt : -1);
    }

    private static void flipM1(int r, int c) {
        if(N < 3 || M < 3) return;
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                m1[i][j] = !m1[i][j];
            }
        }
    }
}